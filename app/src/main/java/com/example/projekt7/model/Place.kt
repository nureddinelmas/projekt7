package com.example.projekt7.model

import java.io.Serializable

data class Place (
                  var title : String = "",
                  var description: String = "",
                  var latitude: Double = 0.0,
                  var longitude: Double = 0.0
) : Serializable