package com.romelapj.quakereport

data class Earthquake(
        /** Magnitude of the earthquake  */
        /**
         * Returns the magnitude of the earthquake.
         */
        val magnitude: Double,
        /** Location of the earthquake  */
        /**
         * Returns the location of the earthquake.
         */
        val location: String,
        /** Time of the earthquake  */
        /**
         * Returns the time of the earthquake.
         */
        val timeInMilliseconds: Long,
        /** Website URL of the earthquake  */
        /**
         * Returns the website URL to find more information about the earthquake.
         */
        val url: String)