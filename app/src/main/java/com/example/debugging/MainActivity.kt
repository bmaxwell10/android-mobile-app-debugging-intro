package com.example.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

// Ref:
// https://developer.android.com/codelabs/basic-android-kotlin-training-intro-debugging
/*
Summary:
- Debugging is the process of troubleshooting the bugs in your code.
- Log allows you to print text with different log levels and tags.
- The stack trace provides information about an exception, such as
  the exact function that caused it and the line number where the
  exception occurred.
- When debugging, chances are someone has encountered the same or
  a similar problem, and you can use sites like StackOverflow to
  research the bug.
- You can easily export both screenshots and animated GIFs using
  the Android emulator. see
 */

private const val TAG = "MainActivity" // added by me

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "this is where the app crashed before")
        val helloTextView: TextView = findViewById(R.id.hello_world)
        Log.d(TAG, "this should be logged if the bug is fixed")
        helloTextView.text = "Hello, debugging!"
        /*
         // Below should not precede setContentView(R.layout.activity_main)
       //  val helloTextView: TextView = findViewById(R.id.hello_world)
       //  helloTextView.text = "Hello, debugging!"
         */
        logging()
       // division() // function intentionally implements a divide by 0 bug
    }

    fun logging() {
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    }

     // attempts to divide by zero.
    fun division() { // introducing a bug
        val numerator = 60
        var denominator = 4
        repeat(5) { // pass in 4 to remove bug
            Log.d(TAG, "$denominator")
            Log.v(TAG, "${numerator / denominator}")
            denominator--
        }
    }
}
