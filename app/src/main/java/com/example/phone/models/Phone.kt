package com.example.phone.models

import java.io.Serializable

class Phone  : Serializable{
    var id : Int? = null
    var name : String? = null
    var model : String? = null
    var comment : String? = null

    constructor(id: Int , name : String , model : String , comment: String){
        this.id = id
        this.name = name
        this.model = model
        this.comment = comment
    }
    constructor(name: String, model: String, comment: String){
        this.name = name
        this.model = model
        this.comment = comment
    }

}