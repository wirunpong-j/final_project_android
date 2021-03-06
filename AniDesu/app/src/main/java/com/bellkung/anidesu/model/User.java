package com.bellkung.anidesu.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BellKunG on 22/10/2017 AD.
 */

public class User implements Parcelable {

    public interface UserDataListener {
        void onDataChanged();
    }

    public interface MyAnimeAddedListener {
        void onAddedSuccess();
        void onAddedFailed(String error);
    }

    public interface MyAnimeEditedListener {
        void onEditedSuccess();
        void onEditedFailed(String error);
    }

    public interface MyAnimeDeletedListener {
        void onDeletedSuccess();
        void onDeletedFailed(String error);
    }

    private static User user = null;

    private String uid;
    private String display_name;
    private String email;
    private String about;
    private String image_url_profile;

    private HashMap<Integer, MyAnimeList> list_plan;
    private HashMap<Integer, MyAnimeList> list_watching;
    private HashMap<Integer, MyAnimeList> list_completed;
    private HashMap<Integer, MyAnimeList> list_dropped;

    private UserDataListener listener;
    private MyAnimeAddedListener myAnimeAddedListener;
    private MyAnimeEditedListener myAnimeEditedListener;
    private MyAnimeDeletedListener myAnimeDeletedListener;

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public User() {}

    public void fetchUserProfile() {
        DatabaseReference mUserRef = FirebaseDatabase.getInstance().getReference("users/" + this.uid + "/profile");
        mUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> user = (Map<String, Object>) dataSnapshot.getValue();
                display_name = String.valueOf(user.get("display_name"));
                about = String.valueOf(user.get("about"));
                email = String.valueOf(user.get("email"));
                image_url_profile = String.valueOf(user.get("image_url_profile"));

                if(listener != null) {
                    listener.onDataChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("Status", "Get User Profile Failed");
            }
        });
    }

    public void fetchMyAnimeList() {
        DatabaseReference mAnimeListRef = FirebaseDatabase.getInstance().getReference("users/" + this.uid + "/list_anime");
        mAnimeListRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                list_plan = new HashMap<>();
                list_watching = new HashMap<>();
                list_completed = new HashMap<>();
                list_dropped = new HashMap<>();

                for (DataSnapshot parent: dataSnapshot.getChildren()) {
                    for (DataSnapshot child: parent.getChildren()) {
                        MyAnimeList myAnimeList = child.getValue(MyAnimeList.class);
                        setMyAnimeFormDB(parent.getKey(), myAnimeList);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }

    private void setMyAnimeFormDB(String status, MyAnimeList myAnimeList) {
        switch (status) {
            case "plan_to_watch":
                this.list_plan.put(myAnimeList.getAnime_id(), myAnimeList);
                break;

            case "watching":
                this.list_watching.put(myAnimeList.getAnime_id(), myAnimeList);
                break;

            case "completed":
                this.list_completed.put(myAnimeList.getAnime_id(), myAnimeList);
                break;

            case "dropped":
                this.list_dropped.put(myAnimeList.getAnime_id(), myAnimeList);
                break;

        }

    }

    public void addMyAnimeList(String status, MyAnimeList myAnime) {

        DatabaseReference mMyAnimeListRef = FirebaseDatabase.getInstance()
                .getReference("users/" + this.uid + "/list_anime/" + status);
        mMyAnimeListRef.push().setValue(myAnime, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    if (myAnimeAddedListener != null) {
                        myAnimeAddedListener.onAddedSuccess();
                    }
                } else {
                    myAnimeAddedListener.onAddedFailed(databaseError.getMessage());
                }
            }
        });

    }

    public void editMyAnimeList(final String old_status, final String new_status, final MyAnimeList newMyAnimeList) {
        DatabaseReference mMyAnimeListRef = FirebaseDatabase.getInstance()
                .getReference("users/" + this.uid + "/list_anime/" + old_status);
        mMyAnimeListRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot parent: dataSnapshot.getChildren()) {

                        Map<String, Object> myAnimeList = (Map<String, Object>) parent.getValue();

                        if (((Long) myAnimeList.get("anime_id")).intValue() == newMyAnimeList.getAnime_id()) {

                            DatabaseReference mOldMyAnimeListRef = FirebaseDatabase.getInstance()
                                    .getReference("users/" + uid + "/list_anime/" + old_status + "/" + parent.getKey());
                            mOldMyAnimeListRef.removeValue();

                            DatabaseReference mNewMyAnimeListRef = FirebaseDatabase.getInstance()
                                    .getReference("users/" + uid + "/list_anime/" + new_status);
                            mNewMyAnimeListRef.push().setValue(newMyAnimeList, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                    if (databaseError == null) {
                                        if (myAnimeEditedListener != null) {
                                            myAnimeEditedListener.onEditedSuccess();
                                        }
                                    } else {
                                        myAnimeEditedListener.onEditedFailed(databaseError.getMessage());
                                    }
                                }
                            });
                            break;
                        }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void deleteMyAnimeList(final String old_status, final MyAnimeList oldMyAnimeList) {

        DatabaseReference mMyAnimeListRef = FirebaseDatabase.getInstance()
                .getReference("users/" + this.uid + "/list_anime/" + old_status);
        mMyAnimeListRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot parent: dataSnapshot.getChildren()) {

                    Map<String, Object> myAnimeList = (Map<String, Object>) parent.getValue();

                    if (((Long) myAnimeList.get("anime_id")).intValue() == oldMyAnimeList.getAnime_id()) {
                        DatabaseReference mOldMyAnimeListRef = FirebaseDatabase.getInstance()
                                .getReference("users/" + uid + "/list_anime/" + old_status + "/" + parent.getKey());
                        mOldMyAnimeListRef.removeValue(new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                if (databaseError == null) {
                                    if (myAnimeDeletedListener != null) {
                                        myAnimeDeletedListener.onDeletedSuccess();
                                    }
                                } else {
                                    myAnimeDeletedListener.onDeletedFailed(databaseError.getMessage());
                                }
                            }
                        });
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImage_url_profile() {
        return image_url_profile;
    }

    public void setImage_url_profile(String image_url_profile) {
        this.image_url_profile = image_url_profile;
    }

    public void setListener(UserDataListener listener) {
        this.listener = listener;
    }

    public HashMap<Integer, MyAnimeList> getList_plan() {
        return list_plan;
    }

    public void setList_plan(HashMap<Integer, MyAnimeList> list_plan) {
        this.list_plan = list_plan;
    }

    public HashMap<Integer, MyAnimeList> getList_watching() {
        return list_watching;
    }

    public void setList_watching(HashMap<Integer, MyAnimeList> list_watching) {
        this.list_watching = list_watching;
    }

    public HashMap<Integer, MyAnimeList> getList_completed() {
        return list_completed;
    }

    public void setList_completed(HashMap<Integer, MyAnimeList> list_completed) {
        this.list_completed = list_completed;
    }

    public HashMap<Integer, MyAnimeList> getList_dropped() {
        return list_dropped;
    }

    public void setList_dropped(HashMap<Integer, MyAnimeList> list_dropped) {
        this.list_dropped = list_dropped;
    }

    public void setMyAnimeAddedListener(MyAnimeAddedListener myAnimeAddedListener) {
        this.myAnimeAddedListener = myAnimeAddedListener;
    }

    public void setMyAnimeEditedListener(MyAnimeEditedListener myAnimeEditedListener) {
        this.myAnimeEditedListener = myAnimeEditedListener;
    }

    public void setMyAnimeDeletedListener(MyAnimeDeletedListener myAnimeDeletedListener) {
        this.myAnimeDeletedListener = myAnimeDeletedListener;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uid);
        dest.writeString(this.display_name);
        dest.writeString(this.email);
        dest.writeString(this.about);
        dest.writeString(this.image_url_profile);
        dest.writeSerializable(this.list_plan);
        dest.writeSerializable(this.list_watching);
        dest.writeSerializable(this.list_completed);
        dest.writeSerializable(this.list_dropped);
        dest.writeParcelable((Parcelable) this.listener, flags);
        dest.writeParcelable((Parcelable) this.myAnimeAddedListener, flags);
        dest.writeParcelable((Parcelable) this.myAnimeEditedListener, flags);
        dest.writeParcelable((Parcelable) this.myAnimeDeletedListener, flags);
    }

    protected User(Parcel in) {
        this.uid = in.readString();
        this.display_name = in.readString();
        this.email = in.readString();
        this.about = in.readString();
        this.image_url_profile = in.readString();
        this.list_plan = (HashMap<Integer, MyAnimeList>) in.readSerializable();
        this.list_watching = (HashMap<Integer, MyAnimeList>) in.readSerializable();
        this.list_completed = (HashMap<Integer, MyAnimeList>) in.readSerializable();
        this.list_dropped = (HashMap<Integer, MyAnimeList>) in.readSerializable();
        this.listener = in.readParcelable(UserDataListener.class.getClassLoader());
        this.myAnimeAddedListener = in.readParcelable(MyAnimeAddedListener.class.getClassLoader());
        this.myAnimeEditedListener = in.readParcelable(MyAnimeEditedListener.class.getClassLoader());
        this.myAnimeDeletedListener = in.readParcelable(MyAnimeDeletedListener.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
