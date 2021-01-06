package com.saregama.mvvmmusicapp.data.local

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class User(
    @Json(name ="user_id")
    var user_id: Int,

    @Json(name ="session_id")
    var session_id: String,

    @Json(name ="device")
    var device: String,

    @Json(name ="email")
    var email: String,

    @Json(name ="user_name")
    var user_name: String,

    @Json(name ="image")
    var image: String,

    @Json(name ="phone")
    var phone: String,

    @Json(name ="sub_status")
    var subStatus: String,

    @Json(name ="selected_model")
    var selected_model: String,

    @Json(name ="primary")
    var primary: String,

    @Json(name ="delink")
    var delink: Boolean,

    @Json(name ="login_type")
    var loginType: String,

//        @Json(name ="game_profile")
//        var gameProfile: GameProfile,

//        @Json(name ="cheque_profile")
//        var chequeProfile: ChequeProfile,

//        @Json(name ="user_tnc")
//        var userTnC: String = "",

    @Json(name ="app_user_tnc")
    var appUserTnC: String = "",

//        @Json(name ="superstar") var superstar: SuperstarResponse = SuperstarResponse(),

    @Json(name ="subscription")
    var subscriptiondetail: ArrayList<SubscriptionDetail>

) {
    fun subscriptionDetail(modal: String): SubscriptionDetail? {
        var subcriptionData: SubscriptionDetail? = null
        for (i in subscriptiondetail.indices) {
            if (modal.equals(subscriptiondetail[i].modal)) {
                subcriptionData = subscriptiondetail[i]
            }
        }
        return subcriptionData
    }
}

data class SubscriptionDetail(
    @Json(name ="serial") var serial: String = "",
    @Json(name ="sub_status") var subStatus: String = "",
    @Json(name ="subscribed") var subscribed: Boolean = false,
    @Json(name ="is_primary") var is_primary: Boolean = false,
    @Json(name ="autorenewal") var autorenewal: Boolean = false,

    @Json(name ="is_payee") var is_payee: Boolean = false,
    @Json(name ="created_timestamp") var startTimestamp: String = "",
    @Json(name ="expiry_timestamp") var expiryTimestamp: String = "",
    @Json(name ="payment_mode") var paymentMode: String = "",
    @Json(name ="carvaan") var modal: String = "",
    @Json(name ="mac_address") var macAddress: String = "",
    @Json(name ="wifi_status") var wifi_status: String = "", // added on 30-04-2020 to send mac address to server
    @Json(name ="wifi_connect") var wifi_connect: Boolean = false, // added on 30-04-2020 to send mac address to server
    @Json(name ="plan") var plan: String = "",

    /**
     * Rating
     */
    @Json(name ="isRatingEnable") var isRatingEnable: Boolean = false,
    @Json(name ="last_popup_shown_timestamp") var last_popup_shown_timestamp: String = "",
    @Json(name ="registered_timestamp") var registered_timestamp: String = ""
)

