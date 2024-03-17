package com.example.contentresolver

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val AUTHORITY = "com.example.contentprovider.AndroidIDProvider"
    val CONTENT_PATH = "backupdata"
    val URL = "content://$AUTHORITY/$CONTENT_PATH"
    val CONTENT_URI = Uri.parse(URL)

    val _ID = "_id"
    val VALUE = "_value"

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        // Retrieve student records
        val c = contentResolver.query(CONTENT_URI, null, null, null, "_value")
        Log.d("123123", "c: $c")
        if (c != null) {
            if (c!!.moveToFirst()) {
                do {
                    Log.d("123123", c.getString(c.getColumnIndex(_ID)) + ", " + c.getString(c.getColumnIndex(VALUE)))
                } while (c.moveToNext())
            }
        }


        //
        val ur = Uri.parse("content://com.example.myapp.provider/data")
        val cursor = contentResolver.query(ur, null, null, null, null)
        // Xử lý dữ liệu từ Cursor
        Log.d("123123", "ur: $ur, cursor: $cursor")


    }
}