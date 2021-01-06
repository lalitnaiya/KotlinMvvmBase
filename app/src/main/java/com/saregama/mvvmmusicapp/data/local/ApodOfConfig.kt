package com.saregama.mvvmmusicapp.data.local

import com.google.gson.annotations.SerializedName

data class ApodOfConfig(
    val response: ResponseCR
)

data class ResponseCR(
    val profile_img: String,
    val image_url: String,
    val album_image: String,
    @SerializedName( "app_version_android")
    val appVersion: AppVersion,
    @SerializedName("voice_search")
    val voiceEnable: VoiceSearch,
    val feedback_mobile: String,
    val feedback_email: String,
    val user_tnc: String,
    val app_tnc: String,
    val app_tnc_url: String,
    val json_song_hindi_meta_data: String,
    val json_song_hindi_karaoke_meta_data: String,
    var last_updated_timestamp: String,
    val hlsURL: String,
    val progressiveURL: String,
    val server_time: String,
    val autorenewal_text: String,
    val carvaan_buy: String,
    val carvaan_refer: String,
    val carvaan_track: String,
    val show_popup: Boolean = false,
    val sub_free: Boolean = false,
    val game_active: Boolean = false,
    val enable_housie: Boolean = false,

    @SerializedName("delay_days") var delayDays: Int = 0,
    @SerializedName("delay_hours") var delayHours: Int = 0,
    @SerializedName("app_session_time_minute") var appSessionTime: Int = 0,
    //added super star
//    @Json(name ="superstar") var superstar: SuperstarResponse

)

data class AppVersion(
    val version: String,
    val versionCode: Int,
    val mandatory_update: Boolean
)

data class VoiceSearch(
    val ios: Boolean, // no use for android but kept here to maintain code base.
    var android: Boolean
)
