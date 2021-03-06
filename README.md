# AniDesu

ANIDESU-Android: >>> https://github.com/wirunpong-j/ANIDESU-Android <<<

ANIDESU-iOS: >>> https://github.com/wirunpong-j/ANIDESU-iOS <<<

## Google Play + APK

### Google Play
ปล. ตอนนี้สามารถลงได้แล้วนะครับ (T^T กว่าจะลงได้ หลายรอบมาก) ตอนนี้ผมใช้ชื่อในการลงว่า AniDezu แทนนะครับ เนื่องจาก AniDesu ติด brand license ครับ เลยต้องลงชื่อนี้แทนครับ

<a href="https://play.google.com/store/apps/details?id=com.bellkung.anidesu&hl=th"><img src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" width="300"></a>

### APK
**>>> https://goo.gl/Di843x <<<**

<strike>ปล. ไม่สามารถลง App ลงใน Play Store ได้เนื่องจากชื่อ App ซ้ำกับ Brand ที่มีอยู่ครับ T^T</strike>

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/21.png" width="1000"><br>

## Features

- สามารถเข้าสู่ระบบโดยใช้ Facebook Account ได้
- สามารถรีวิว (Review) อนิเมะที่ดูแล้วได้
- สามารถเพิ่ม (Add) หรือแก้ไข (Edit) รายการอนิเมะที่ จะดู (Plan to watch), กำลังดู (Watching), ดูจบแล้ว (Completed) และเลิกดู (Dropped) แล้วได้
- สามารถทำการ Post Status, comment และ กด like ได้
- สามารถค้นหาอนิเมะที่สนใจได้

## Design

### Theme

UI ของ Application ออกแบบตาม Material Design ของ Android ซึ่งใช้ความเรียบง่าย โดยใน Application จะใช้สีดำเป็นสีหลัก



### Layout
- **Welcome :** หน้าแรกที่เข้ามาจะเป็นหน้า Login ต้องใช้ Facebook Account แต่ถ้า Login ไว้แล้วจะเด้งไปหน้า Home

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/1.png" width="300"><br>

- **Navigation Bar :** แสดง Menu และข้อมูลส่วนตัวของ User

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/5.png" width="300"><br>

- **Home :** หน้าหลักของ Application จะเป็นหน้าที่รวบรวม Status (Feed) ของสมาชิก AniDesu ทั้งหมดที่ทำการ Post ไว้ โดยในหน้า Home นั้นจะประกอบไปด้วยหน้าย่อย ๆ ได้อีก 2 หน้า คือ

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/2.png" width="300"><br><br>
  1.) Create Post : หน้าที่ไว้ให้สำหรับสมาชิกต้องการจะ Post Status <br><br>
<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/3.png" width="300"><br><br>
  2.) Comment this post : หน้าที่ไว้เมื่อสมาชิกต้องการจะแสดงความคิดเห็น (Comment) ของ Post ที่สนใจ <br><br>
<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/4.png" width="300"><br>

- **Discover Anime :** หน้าที่รวบรวมและแสดงอนิเมะญี่ปุ่นทั้งหมด โดยจะแบ่งเป็น ฤดูกาล (Season) ได้แก่ Winter, Spring, Summer และ Fall โดยเมื่อเลือกดูข้อมูลของอนิเมะแต่ละเรื่อง

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/6.png" width="300"><br>

- **Anime Overview :** หน้าที่แสดงรายละเอียดของอนิเมะแต่ละเรื่อง ตามที่ User เลือกดู โดยจะแบ่งเป็นหน้าย่อย ๆ ได้อีก 4 หน้า คือ
  - Info : หน้าที่แสดงรายละเอียดของอนิเมะ เช่น ชื่อเรื่อง, เรื่องย่อ, ประเภท, จำนวนตอน, ฉายวันที่ ฯลฯ เป็นต้น
  - Stats : หน้าที่แสดง Website ที่เกี่ยวข้องกับ Anime เรื่องนั้น ๆ และแสดงจำนวนที่สมาชิก ทำการ Add to My Anime List ไว้
  - Extras : หน้าที่แสดงชื่อตัวละคร และผู้สร้างที่อยู่ใน Anime เรื่องนั้น ๆ
  - Reviews : หน้าที่แสดง Reviews ของสมาชิกที่ได้ดูเรื่องนี้ ไม่ว่าจะเป็น Reviews เชิงบวกหรือเชิงลบ

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/7.png" width="300"> <img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/8.png" width="300"><br>
<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/9.png" width="300"> <img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/10.png" width="300"><br>

- **ADD/EDIT My Anime List :** หน้าที่ เพิ่ม แก้ไข ลบ Anime ที่อยู่ใน My Anime List โดยระบบจะเก็บ สถานะของ Anime, ตอนที่ดู, คะแนนโดยรวม และ Notes เป็นต้น

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/11.png" width="300"> <img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/15.png" width="300"><br>

- **ADD Review :** หน้าที่ เพิ่ม Review ให้กับ Anime ที่สนใจ โดยการคะแนน (ดาว) และใส่ข้อความที่ต้องการจะ Review

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/12.png" width="300"><br>

- **Share Anime :** หน้าที่ทำการ Share Anime ไปยัง Application อื่น ๆ

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/13.png" width="300"><br>

- **My Anime List :** หน้าที่ทำการแสดง Anime ทั้งหมดที่ User ทำการ Add ไว้ โดยจะแบ่งเป็น 4 ประเภทคือ Plan to Watch (วางแผนจะดู), Watching (กำลังดู), Completed (ดูเสร็จแล้ว) และ เลิกดู (Dropped)  โดยจะแสดงข้อมูลแบบคร่าว ๆ เช่น ชื่อเรื่อง, ตอนที่กำลังดู และคะแนน เป็นต้น

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/14.png" width="300"><br>

- **Anime Review :** หน้าที่รวมข้อมูลการ Review ของทุก User ที่ทำการ Review ไว้ เมื่อกดที่ Read more จะทำการแสดง Review ของ Review นั้น ๆ โดยละเอียด

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/16.png" width="300"> <img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/17.png" width="300"><br>

- **Anime Search :** ช่องที่ไว้สำหรับการค้นหา หา Anime ที่สนใจ และแสดง Anime ทั้งหมด ที่ใกล้เคียงกับคำค้นหา

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/18.png" width="300"> <img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/19.png" width="300">

## APIs

### Anilist API

```html
https://anilist.co/api/
```

ใช้เพื่อดึงข้อมูลอนิเมะทั้งหมด ไม่ว่าจะเป็น ชื่อเรื่อง, วันฉายอนิเมะ, วันที่อนิเมะจบ, จำนวนตอนทั้งหมด, รูปของอนิเมะนั้น ๆ ฯลฯ เป็นต้น



#### Access Token

ขอ Access Token จาก Anilist APIs เพื่อจะสามารถดึงข้อมูลมาใช้ได้

##### Request example :

```
POST: auth/access_token

Url Parms:
grant_type    : "client_credentials"
client_id     : "bbellkungdesu-kungd"
client_secret : "L5gVawdnzKUYaABC2saoXZRq0rz"
```

##### Response example :

```json
{
    "access_token": "NR3M3vXgHK0kmluOcJVlRXvbGOg4yLhAVyf5If",
    "token_type": "bearer",
    "expires": 1414234981,
    "expires_in": 3600
}
```



#### Browse Anime

เรียกข้อมูล Anime ทั้งหมดที่มีอยู่ใน AniList APIs โดยจะได้ Model แบบย่อมา

##### Request Example : 

```
Get: browse/{series_type}

Header:
Authorization	: "Bearer NR3M3vXgHK0kmluOcJVlRXvbGOg4yLhAVyf5If"

Path:
{series_type}	: "anime"

Url Parms:
year		: 2017
season		: "winter"
full_page	: true
airing_Data	: true
```

##### Response example :

```json
[{
    "id": 17947,
    "title_romaji": "Mahou Shoujo Lyrical Nanoha: Reflection",
    "title_english": "Magical Girl Lyrical Nanoha: Reflection",
    "title_japanese": "魔法少女リリカルなのはReflection",
    "type": "Movie",
    "start_date_fuzzy": 20170722,
    "end_date_fuzzy": 20170722,
    "season": 173,
    "series_type": "anime",
    "synonyms": [],
    "genres": [
        "Action",
        "Comedy",
        "Drama",
        "Mahou Shoujo"
    ],
    "adult": false,
    "average_score": 0,
    "popularity": 539,
    "updated_at": 1511801686,
    "hashtag": null,
    "image_url_sml": "https://cdn.anilist.co/img/dir/anime/sml/17947-QTSoKwtDlzFJ.jpg",
    "image_url_med": "https://cdn.anilist.co/img/dir/anime/med/17947-QTSoKwtDlzFJ.jpg",
    "image_url_lge": "https://cdn.anilist.co/img/dir/anime/reg/17947-QTSoKwtDlzFJ.jpg",
    "image_url_banner": null,
    "total_episodes": 1,
    "airing_status": "finished airing",
    "airing": null,
    "tags": [
        {
            "id": 29,
            "name": "Magic",
            "description": "Prominently features magical elements or the use of magic.",
            "spoiler": false,
            "adult": false,
            "demographic": false,
            "denied": 0,
            "category": "Theme-Fantasy",
            "votes": 79,
            "series_spoiler": false
        }
    ]
}, 
/// More........................
]
```


#### Fetch Anime Data

เรียกข้อมูลของแต่ละ Anime โดยจะได้ Model แบบละเอียดมา

##### Request example : 

```
GET: {series}/{id}/page

Header:
Authorization	: "Bearer NR3M3vXgHK0kmluOcJVlRXvbGOg4yLhAVyf5If"

Path:
{series}	: "anime"
{id}		: 21825
```

##### Response example :

```json
{
    "id": 21825,
    "title_romaji": "Danganronpa 3: The End of Kibougamine Gakuen - Zetsubou-hen",
    "title_english": "Danganronpa 3: The End of Hope’s Peak High School - Despair Arc",
    "title_japanese": "ダンガンロンパ3 -The End of 希望ヶ峰学園-　絶望編",
    "type": "TV",
    "series_type": "anime",
    "start_date": "2016-07-14T00:00:00+09:00",
    "end_date": "2016-09-22T00:00:00+09:00",
    "start_date_fuzzy": 20160714,
    "end_date_fuzzy": 20160922,
    "season": 163,
    "description": "The prequel to the 2012 PSP game, Danganronpa 2: Goodbye Despair. It will tell the story of the Remnants of Despair, a group featured in the game, while the other anime airing alongside (Mirai-hen) will act as a sequel to the game.",
    "adult": false,
    "average_score": 73,
    "mean_score": 75,
    "popularity": 2443,
    "favourite": false,
    "image_url_sml": "https://cdn.anilist.co/img/dir/anime/sml/21825-oV4EMLnoWVYh.png",
    "image_url_med": "https://cdn.anilist.co/img/dir/anime/med/21825-oV4EMLnoWVYh.png",
    "image_url_lge": "https://cdn.anilist.co/img/dir/anime/reg/21825-oV4EMLnoWVYh.png",
    "image_url_banner": null,
    "genres": [
        "Action",
        "Horror",
        "Mystery",
        "Psychological"
    ],
    "synonyms": [],
    "youtube_id": null,
    "hashtag": "#ダンガンロンパ",
    "updated_at": 1511801354,
    "total_episodes": 11,
    "duration": 24,
    "airing_status": "finished airing",
  /// More.................
}
```



#### Anime Search

ค้นหา Anime ที่ต้องการด้วยการใส่ชื่อหรือคำค้นหาต่าง ๆ โดยจะได้ ข้อมูลของ Anime ที่ใกล้เคียงคำค้นหามาใน Model แบบย่อ

##### Request example : 

```
GET: {series_type}/search/{query}

Header:
Authorization	: "Bearer NR3M3vXgHK0kmluOcJVlRXvbGOg4yLhAVyf5If"

Path:
{series_type}	: "anime"
{query}		: "umaru"
```

##### Response example :

```json
[
{
    "id": 20987,
    "title_romaji": "Himouto! Umaru-chan",
    "title_english": "Himouto! Umaru-chan",
    "title_japanese": "干物妹！うまるちゃん",
    "type": "TV",
    "series_type": "anime",
    "start_date": "2015-07-09T00:00:00+09:00",
    "end_date": "2015-09-24T00:00:00+09:00",
    "start_date_fuzzy": 20150709,
    "end_date_fuzzy": 20150924,
    "season": 153,
    "description": "An anime adaptation of Himouto! Umaru-chan manga. The sibling gag comedy manga centers around Umaru, Taihei's little sister who boasts beautiful looks as well as prowess in both school and sports. However, \"Himouto\" (beautiful little sister) has a certain secret.<br>\n<br>\n(Source ANN)",
    "adult": false,
    "average_score": 71,
    "mean_score": 72,
    "popularity": 5994,
    "favourite": false,
    "image_url_sml": "https://cdn.anilist.co/img/dir/anime/sml/20987-tHsGmyqcZFV2.png",
    "image_url_med": "https://cdn.anilist.co/img/dir/anime/med/20987-tHsGmyqcZFV2.png",
    "image_url_lge": "https://cdn.anilist.co/img/dir/anime/reg/20987-tHsGmyqcZFV2.png",
    "image_url_banner": "https://cdn.anilist.co/img/dir/anime/banner/20987-3bjbyj06ZcSF.jpg",
    "genres": [
        "Comedy",
        "Slice of Life"
    ],
    "synonyms": [],
    "youtube_id": "J92h4Fr3WiM",
    "hashtag": "#umaru_anime",
    "updated_at": 1511887840,
    "total_episodes": 12,
    "duration": 24,
    "airing_status": "finished airing",
    "source": "Manga",
    "classification": "",
    "airing_stats": []
},
{
    "id": 21327,
    "title_romaji": "Himouto! Umaru-chan OVA",
    "title_english": "Himouto! Umaru-chan OVA",
    "title_japanese": "干物妹！うまるちゃん OVA",
    "type": "OVA",
    "series_type": "anime",
    "start_date": "2015-10-19T00:00:00+09:00",
    "end_date": "2017-04-19T00:00:00+09:00",
    "start_date_fuzzy": 20151019,
    "end_date_fuzzy": 20170419,
    "season": 154,
    "description": "Episodes included in the manga's seventh and tenth volume.",
    "adult": false,
    "average_score": 69,
    "mean_score": 72,
    "popularity": 1030,
    "favourite": false,
    "image_url_sml": "https://cdn.anilist.co/img/dir/anime/sml/21327-1qTi4wb3XyxB.jpg",
    "image_url_med": "https://cdn.anilist.co/img/dir/anime/med/21327-1qTi4wb3XyxB.jpg",
    "image_url_lge": "https://cdn.anilist.co/img/dir/anime/reg/21327-1qTi4wb3XyxB.jpg",
    "image_url_banner": null,
    "genres": [
        "Comedy",
        "Slice of Life"
    ],
    "synonyms": [],
    "youtube_id": null,
    "hashtag": "#umaru_anime",
    "updated_at": 1511801427,
    "total_episodes": 2,
    "duration": 24,
    "airing_status": "finished airing",
    "source": "Manga",
    "classification": "",
    "airing_stats": []
},
  /// More...............
]
```

### Facebook Login API

ใช้ในการ Login ด้วย Facebook Account และดึงข้อมูลของ User

```java
mCallbackManager = CallbackManager.Factory.create();
LoginButton fbLoginBtn = findViewById(R.id.login_button);
fbLoginBtn.setReadPermissions("email", "public_profile");
fbLoginBtn.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
    @Override
    public void onSuccess(LoginResult loginResult) {
        showIndicatorView();
        Log.d("Status : ", "facebook:onSuccess:" + loginResult);
        handleFacebookAccessToken(loginResult.getAccessToken());
    }

    @Override
    public void onCancel() {
        Log.d("Status : ", "facebook:onCancel");
    }

    @Override
    public void onError(FacebookException error) {
        Log.d("Status : ", "facebook:onError", error);
    }
});
```



### Firebase

ใช้ Firebase เป็น Backend ซึ่งจะคอยจัดการเกี่ยวกับระบบ Authentication และ การบันทึกข้อมูลลง Database



- #### Authentication

  ใช้ Firebase ในการสร้างและจัดการข้อมูลของ User

```java
private void handleFacebookAccessToken(AccessToken token) {
    AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
    this.mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                       // Sign in success, update UI with the signed-in user's information
                        Log.d("Status : ", "signInWithCredential:success");
                        FirebaseUser user = mAuth.getCurrentUser();

                        AnotherUser anotherUser = new AnotherUser();
                        anotherUser.setUid(user.getUid());
                        anotherUser.setAbout("Welcome To AniDesu");
                        anotherUser.setDisplay_name(user.getDisplayName());
                        anotherUser.setEmail(user.getEmail());
                        anotherUser.setImage_url_profile(user.getPhotoUrl().toString());

                        accountService.setCurrentAccountListener(MainActivity.this);
                        accountService.isCurrentAccount(anotherUser);

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Status : ", "signInWithCredential:failure", 	
                        task.getException());
                    }
                }
            });
}
```

- #### Realtime Database

  ใช้ในการจัดการฐานข้อมูล เช่น การบันทึก แก้ไข ลบข้อมูลใน Database โดยใน Application จะทำการเก็บข้อมูลของ Posts, User, Series และ Reviews




## Review

### Present + Monkey Test

**>>> https://www.youtube.com/watch?v=oHZg4yd-XBY <<<**

### Other Review

**>>> https://www.youtube.com/watch?v=csNyH_cePSg <<<**



## Testing

### UI Test (เพิ่มเติม)

*** ปล. การที่ UI Test จะผ่าน 100% ต้องทำการ Login ไว้ก่อน  Pleaseeeeeeeeee ***

#### 1. AnimeListFragmentUITest

- **Case 1 - showAnimeEachSeason :** Check การ Click ปุ่มการเลือก ฤดูของ Anime (Season ได้แก่ Winter, Spring, Summer และ Fall)  ว่าสามารถทำได้อย่างถูกต้อง

- **Case 2 - showOverviewAnime :** Check ว่าเมื่อทำการ Click ที่ภาพ Anime ที่เลือกในหน้า Discover Anime แล้วจะต้องขึ้นหน้า AnimeOverview ใหม่ และต้องสามารถ Click ปุ่มการเลือกดูรายละเอียดของ Anime นั้น ๆ ได้ (ได้แก่ Info, Stats, Extras และ Reviews) ว่าสามารถทำงานได้อย่างถูกต้อง


#### 2. AnimeReviewUITest

- **Case 1 - scrollView :** Check ว่า RecyclerView สามารถ Scroll ลงมาได้

- **Case 2 - showHoverViewOfReview :** Check ว่าเมื่อ Click ตรงแต่ละ Review  ในหน้า Anime Review จะตัองมี Hover แบบย่อขึ้นมา

- **Case 3 - showReviewFormUser :** Check ว่าเมื่อทำการ Click ที่ปุ่ม Read more จะต้องทำการแสดงข้อมูลการ Review แบบละเอียดในหน้าต่างใหม่


#### 3. AnimeSearchActivityUITest

- **Case 1 - searchAnimeWithBlank :** Check ว่าเมื่อทำการค้นหาชื่อ Anime ด้วยการไม่ใส่อะไรเลยหรือใส่ช่องว่าง จะต้องแสดงหน้า No Data to Display
- **Case 2 - searchAnimeWithMissingName :** Check ว่าเมื่อทำการค้นหาชื่อ Anime ด้วยการใส่คำค้นหาที่ไม่ใกล้เคียงเลยกับข้อมูลที่มีในระบบ จะต้องแสดงหน้า No Data to Display
- **Case 3 - searchAnimeWithSimilarName :** Check ว่าเมื่อทำการค้นหาชื่อ Anime ด้วยการใส่คำค้นหาที่ใกล้เคียงกับข้อมูลที่มีในระบบ จะต้องแสดง List ของ Anime ที่ใกล้เคียงกับคำค้นหาทั้งหมด


#### 4. CommentPostActivityUITest

- **Case 1 - commentBtnPressed :** Check ว่าเมื่อมีการ Click ที่ปุ่มดู Comment จะต้องแสดงหน้าต่างของ Comment ต่าง ๆ ใน Post นั้น ๆ
- **Case 2 - commentThisPost :** Check ว่าเมื่อมีการ Comment Post เสร็จแล้ว จะต้องมีการ Update ต่อท้าย List ของ Comment ล่าสุด


#### 5. HomeActivityUITest

- **Case 1 - navigationBarPressed :** Check ว่าเมื่อทำการ Click Navigation Bar จะต้องแสดงออกมา
- **Case 2 - navHomePressed :** Check ว่าเมื่อมีการ Click ที่ Menu Home จะต้องแสดงหน้า Status ขึ้นมา
- **Case 3 - navDiscoverAnimePressed :** Check ว่าเมื่อมีการ Click ที่ Menu Discover Anime จะต้องแสดงหน้า Discover Anime ขึ้นมา
- **Case 4 - navMyAnimeListPressed :** Check ว่าเมื่อมีการ Click ที่ Menu My Anime List จะต้องแสดงหน้า My Anime List ขึ้นมา
- **Case 5 - navAnimeReviewPressed :** Check ว่าเมื่อมีการ Click ที่ Menu Anime Review จะต้องแสดงหน้า Anime Review ขึ้นมา


#### 6. showMyAnimeEachStatus

- **Case 1 - showMyAnimeEachStatus :** Check การ Click ปุ่มการเลือกสถานะของ My Anime List (ได้แก่ Plan To Watch, Watching, Completed และ Dropped)  ว่าสามารถทำได้อย่างถูกต้อง


#### 7. PostActivityUITest

- **Case 1 - postBoomMenuButtonPressed :** Check ว่าเมื่อมีการ Click ที่ Boom menu button จะต้องแสดง Create Post Button ได้อย่างถูกต้อง
- **Case 2 - postStatus :** Check ว่าเมื่อมีการ ทำการ Post จะต้องกลับไปยังหน้ารวม Post จึงจะเรียกว่า Post สำเร็จ

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/22.png" width="1000"><br>

### Unit Testing

#### FormatCustomManagerTest

คือ Class ที่ Check ว่ามี Case ใดบ้างที่ใส่ค่ามาแล้วพอแปลงค่า จะถูกต้องหรือไม่

- **Case 1 - parseNullToNATextCompleted :** Check ว่า เมื่อกรอก String ที่เป็น null เข้าไป เช่น

  **input :** null จะต้อง **return :** "N/A"

- **Case 2 - parseNullToNATextCompleted :** Check ว่า เมื่อกรอก String ที่เป็น String ธรรมดาเข้าไป เช่น

  **input :** "Bell" จะต้อง **return :** "Bell"

- **Case 3 - parseIntToDateCompleted :** Check ว่า Integer ที่รับเข้ามาจะต้องแปลงเป็น String ของวันที่ ตาม Pattern ได้ เช่น

  **input :** 20171001 จะต้อง **return :** "01 Oct 2017"

- **Case 4 - parseIntToDateFailed :** Check ว่า Integer ที่รับเข้ามานั้นจะต้องไม่สามารถแปลงเป็น String ของวันที่ตาม Pattern ได้ เช่น

  **input :** 0223 จะต้อง **return :**  "N/A"

- **Case 5 - parseStringToFirebaseDatetimeCompleted :** Check ว่า String ที่รับเข้ามาเพื่อจะแปลงเป็นรูปแบบวันที่ของ Firebase นั้นตรงตาม Pattern

  **input :** "2017-10-07-22-33" จะต้อง **return :**  "07 Oct 2017 - 22:33"

- **Case 6 - parseStringToFirebaseDatetimeFailed :** Check ว่า String ที่รับเข้ามาเพื่อจะแปลงเป็นรูปแบบวันที่ของ Firebase นั้น ไม่ตรงตาม Pattern

  **input :** "2017-aasd" จะต้อง **return :**  "N/A"

<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/20.png" width="1000"><br>

## Full Coverage Report
<img src="https://github.com/wirunpong-j/final_project_android/blob/master/wiki/image/23.png" width="1000"><br>
