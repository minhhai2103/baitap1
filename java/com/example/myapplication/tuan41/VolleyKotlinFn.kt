package com.example.myapplication.tuan41

import android.content.Context
import android.widget.TextView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class VolleyKotlinFn {
    var strJSON=""
    fun getJSON_ArrayObjects(context: Context,textView: TextView)
    {
        val queue= Volley.newRequestQueue(context)
        val url="http://nguyenvantuanolivas.mooo.com/api2/customer"
        val request=JsonArrayRequest(url,
            Response.Listener {
                response ->
                for(i in 0 until response.length())
                {
                    val person=response.getJSONObject(i)
                    val id=person.getString("id")
                    val name=person.getString("cus_name")
                    val email=person.getString("email")
                    strJSON += "id: $id\n"
                    strJSON += "cus_name: $name\n"
                    strJSON += "email: $email\n"
                }
                textView.text=strJSON
            },
            Response.ErrorListener {
                error ->  textView.text= error.message
            })
        queue.add(request)
    }
}