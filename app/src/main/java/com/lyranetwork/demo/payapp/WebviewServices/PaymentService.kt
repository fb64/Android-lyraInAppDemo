package com.lyranetwork.demo.payapp.WebviewServices

import android.content.ContentValues.TAG
import android.util.Log
import android.webkit.URLUtil
import com.lyranetwork.demo.payapp.retrofit.APIClient
import com.lyranetwork.demo.payapp.retrofit.APIInterface
import com.lyranetwork.demo.payapp.retrofit.PerformInit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by asoler on 16/10/2017.
 */

class PaymentService(_email: String, _amount: Int, _mode: String, _lang: String,
                     _card: String) {
    var email = _email
    val amount = _amount
    val mode = _mode
    val lang = _lang
    val card = _card

    private lateinit var apiInterface: APIInterface

    /**
     * Get PaymentContext
     * Call PerformInit WS (GET) with retrofit
     **/
    fun getPaymentContext(complete: (Boolean, String?) -> Unit) {
        Log.d(TAG, "email = " + email)
        Log.d(TAG, "amount = " + amount)
        Log.d(TAG, "mode = " + mode)
        Log.d(TAG, "lang = " + lang)
        Log.d(TAG, "card = " + card)

        if (email.isEmpty()) {
            email = "noemail"
        }

        // Init Retrofit
        apiInterface = APIClient.client.create(APIInterface::class.java)

        val call = apiInterface.doGetPerformInit(email, amount.toString(), mode, lang, card)
        call.enqueue(object : Callback<PerformInit> {
            override fun onResponse(call: Call<PerformInit>?, response: Response<PerformInit>?) {
                Log.d("TAG", response?.code().toString() + "")
                if (response?.code() == 200) {
                    val redirectUrl = response.body()?.redirectUrl as String
                    if (URLUtil.isValidUrl(redirectUrl)) {
                        return complete(true, redirectUrl)
                    }
                } else {
                    return complete(false, null)
                }
            }

            override fun onFailure(call: Call<PerformInit>?, t: Throwable?) {
                call?.cancel();
                return complete(false, null)
            }
        })
    }
}