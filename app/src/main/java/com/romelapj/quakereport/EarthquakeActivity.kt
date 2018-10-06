package com.romelapj.quakereport

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class EarthquakeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_earthquake)

        // Get the list of earthquakes from {@link QueryUtils}
        val earthquakes = QueryUtils.extractEarthquakes()

        // Find a reference to the {@link ListView} in the layout
        val earthquakeListView = findViewById<View>(R.id.list) as ListView

        // Create a new adapter that takes the list of earthquakes as input
        val adapter = EarthquakeAdapter(this, earthquakes)

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.adapter = adapter

        // Set an item click listener on the ListView, which sends an intent to a web browser
        // to open a website with more information about the selected earthquake.
        earthquakeListView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, l ->
            // Find the current earthquake that was clicked on
            val currentEarthquake = adapter.getItem(position)

            // Convert the String URL into a URI object (to pass into the Intent constructor)
            val earthquakeUri = Uri.parse(currentEarthquake?.url)

            // Create a new intent to view the earthquake URI
            val websiteIntent = Intent(Intent.ACTION_VIEW, earthquakeUri)

            // Send the intent to launch a new activity
            startActivity(websiteIntent)
        }
    }

    companion object {

        val LOG_TAG = EarthquakeActivity::class.java.name
    }
}