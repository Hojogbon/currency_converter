package com.hojogbon.mytaskapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create the
        val clickMe = findViewById<Button>(R.id.clickme)
        clickMe.setOnClickListener {
            sendmailUrl()
        }
        // link profile to linkedin
        val linkedinContact = findViewById<ImageView>(R.id.linkedinicon)
        linkedinContact.setOnClickListener{
            val linkedinProfilepath = "www.linkedin.com/in/oyebola-odeleye-b19753158"
            val linkedinPackageName = "https://www.linkedin.com/"
            toMyTaskApplication(linkedinProfilepath, linkedinPackageName)
        }

        // create a profile link to twitter
        val twitterContact: ImageView = findViewById<ImageView>(R.id.twittericon)
        twitterContact.setOnClickListener {
            val twitterProfilepath = "https://twitter.com/OYEBEEONE"
            val twitterPackageName = "https://www.twitter.com/"
            toMyTaskApplication(twitterProfilepath,twitterPackageName)
        }

     }
    // create the function to handle the linking of twitter and linkedin profile
     private fun toMyTaskApplication(linkedinProfilepath: String, linkedinPackageName: String) {
        val uri = Uri.parse(linkedinPackageName)
        try{
            startActivity(Intent(Intent.ACTION_VIEW, uri).setPackage(linkedinPackageName))

        }catch (e:Exception){
            startActivity(Intent(Intent.ACTION_VIEW, uri))

        }

    }
    // create a function for the email intent
   private fun sendmailUrl() {
       val mIntent = Intent(Intent.ACTION_SEND)
       val message = "congratulations, you have been hired!!"
       val mailAddressUrl = "hojogbon@gmail.com=$packageName"
        mIntent.data = Uri.parse("mailto: ")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, mailAddressUrl)
        mIntent.putExtra(Intent.EXTRA_SUBJECT, message)

        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Send message to hojogbon"))
        }
        catch (e: Exception){
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
   }
}





