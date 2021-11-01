package com.example.friendsapp.features.home.model


import android.os.Parcel
import android.os.Parcelable
import com.example.friendsapp.core.platform.KParcelable
import com.google.gson.annotations.SerializedName


class UserResults {

    @SerializedName("results")
    var results: List<Results> = ArrayList()

    @SerializedName("info")
    var info: Info? = null

}


class Name (

    @SerializedName("title") var title : String,
    @SerializedName("first") var first : String,
    @SerializedName("last") var last : String

): KParcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(first)
        parcel.writeString(last)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Name> {
        override fun createFromParcel(parcel: Parcel): Name {
            return Name(parcel)
        }

        override fun newArray(size: Int): Array<Name?> {
            return arrayOfNulls(size)
        }
    }

}

 class Street (

    @SerializedName("number") var number : Int,
    @SerializedName("name") var name : String

): KParcelable{
     constructor(parcel: Parcel) : this(
         parcel.readInt(),
         parcel.readString()!!
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {
         parcel.writeInt(number)
         parcel.writeString(name)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Street> {
         override fun createFromParcel(parcel: Parcel): Street {
             return Street(parcel)
         }

         override fun newArray(size: Int): Array<Street?> {
             return arrayOfNulls(size)
         }
     }

 }

 class Coordinates (

    @SerializedName("latitude") var latitude : String,
    @SerializedName("longitude") var longitude : String

): KParcelable{
     constructor(parcel: Parcel) : this(
         parcel.readString()!!,
         parcel.readString()!!
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {
         parcel.writeString(latitude)
         parcel.writeString(longitude)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Coordinates> {
         override fun createFromParcel(parcel: Parcel): Coordinates {
             return Coordinates(parcel)
         }

         override fun newArray(size: Int): Array<Coordinates?> {
             return arrayOfNulls(size)
         }
     }

 }

 class Timezone (

    @SerializedName("offset") var offset : String,
    @SerializedName("description") var description : String

): KParcelable{
     constructor(parcel: Parcel) : this(
         parcel.readString()!!,
         parcel.readString()!!
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {

         parcel.writeString(offset)
         parcel.writeString(description)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Timezone> {
         override fun createFromParcel(parcel: Parcel): Timezone {
             return Timezone(parcel)
         }

         override fun newArray(size: Int): Array<Timezone?> {
             return arrayOfNulls(size)
         }
     }

 }
 class Location (

    @SerializedName("street") var street : Street,
    @SerializedName("city") var city : String,
    @SerializedName("state") var state : String,
    @SerializedName("country") var country : String,
    @SerializedName("postcode") var postcode : String,
    @SerializedName("coordinates") var coordinates : Coordinates,
    @SerializedName("timezone") var timezone : Timezone

): KParcelable{
     constructor(parcel: Parcel) : this(
         parcel.readParcelable(Street::class.java.classLoader)!!,
         parcel.readString()!!,
         parcel.readString()!!,
         parcel.readString()!!,
         parcel.readString()!!,
         parcel.readParcelable(Coordinates::class.java.classLoader)!!,
         parcel.readParcelable(Timezone::class.java.classLoader)!!
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {

         parcel.writeParcelable(street, flags)
         parcel.writeString(city)
         parcel.writeString(state)
         parcel.writeString(country)
         parcel.writeString(postcode)
         parcel.writeParcelable(coordinates, flags)
         parcel.writeParcelable(timezone, flags)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Location> {
         override fun createFromParcel(parcel: Parcel): Location {
             return Location(parcel)
         }

         override fun newArray(size: Int): Array<Location?> {
             return arrayOfNulls(size)
         }
     }

 }


class Login (

    @SerializedName("uuid") var uuid : String,
    @SerializedName("username") var username : String,
    @SerializedName("password") var password : String,
    @SerializedName("salt") var salt : String,
    @SerializedName("md5") var md5 : String,
    @SerializedName("sha1") var sha1 : String,
    @SerializedName("sha256") var sha256 : String

) : KParcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(uuid)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(salt)
        parcel.writeString(md5)
        parcel.writeString(sha1)
        parcel.writeString(sha256)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Login> {
        override fun createFromParcel(parcel: Parcel): Login {
            return Login(parcel)
        }

        override fun newArray(size: Int): Array<Login?> {
            return arrayOfNulls(size)
        }
    }

}

 class Dob (

    @SerializedName("date") var date : String,
    @SerializedName("age") var age : Int

) :KParcelable{
     constructor(parcel: Parcel) : this(
         parcel.readString()!!,
         parcel.readInt()
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {

         parcel.writeString(date)
         parcel.writeInt(age)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Dob> {
         override fun createFromParcel(parcel: Parcel): Dob {
             return Dob(parcel)
         }

         override fun newArray(size: Int): Array<Dob?> {
             return arrayOfNulls(size)
         }
     }

 }


 class Registered (

    @SerializedName("date") var date : String,
    @SerializedName("age") var age : Int

) : KParcelable{
     constructor(parcel: Parcel) : this(
         parcel.readString()!!,
         parcel.readInt()
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {
         parcel.writeString(date)
         parcel.writeInt(age)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Registered> {
         override fun createFromParcel(parcel: Parcel): Registered {
             return Registered(parcel)
         }

         override fun newArray(size: Int): Array<Registered?> {
             return arrayOfNulls(size)
         }
     }

 }


class Id (

    @SerializedName("name") var name : String,
    @SerializedName("value") var value : String

) : KParcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(name)
        parcel.writeString(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Id> {
        override fun createFromParcel(parcel: Parcel): Id {
            return Id(parcel)
        }

        override fun newArray(size: Int): Array<Id?> {
            return arrayOfNulls(size)
        }
    }

}

 class Picture (

    @SerializedName("large") var large : String,
    @SerializedName("medium") var medium : String,
    @SerializedName("thumbnail") var thumbnail : String

) : KParcelable{
     constructor(parcel: Parcel) : this(
         parcel.readString()!!,
         parcel.readString()!!,
         parcel.readString()!!
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {

         parcel.writeString(large)
         parcel.writeString(medium)
         parcel.writeString(thumbnail)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Picture> {
         override fun createFromParcel(parcel: Parcel): Picture {
             return Picture(parcel)
         }

         override fun newArray(size: Int): Array<Picture?> {
             return arrayOfNulls(size)
         }
     }

 }

class Results (

    @SerializedName("gender") var gender : String,
    @SerializedName("name") var name : Name,
    @SerializedName("location") var location : Location,
    @SerializedName("email") var email : String,
    @SerializedName("login") var login : Login,
    @SerializedName("dob") var dob : Dob,
    @SerializedName("registered") var registered : Registered,
    @SerializedName("phone") var phone : String,
    @SerializedName("cell") var cell : String,
    @SerializedName("id") var id : Id,
    @SerializedName("picture") var picture : Picture,
    @SerializedName("nat") var nat : String

): KParcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readParcelable(Name::class.java.classLoader)!!,
        parcel.readParcelable(Location::class.java.classLoader)!!,
        parcel.readString()!!,
        parcel.readParcelable(Login::class.java.classLoader)!!,
        parcel.readParcelable(Dob::class.java.classLoader)!!,
        parcel.readParcelable(Registered::class.java.classLoader)!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readParcelable(Id::class.java.classLoader)!!,
        parcel.readParcelable(Picture::class.java.classLoader)!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(gender)
        parcel.writeParcelable(name, flags)
        parcel.writeParcelable(location, flags)
        parcel.writeString(email)
        parcel.writeParcelable(login, flags)
        parcel.writeParcelable(dob, flags)
        parcel.writeParcelable(registered, flags)
        parcel.writeString(phone)
        parcel.writeString(cell)
        parcel.writeParcelable(id, flags)
        parcel.writeParcelable(picture, flags)
        parcel.writeString(nat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Results> {
        override fun createFromParcel(parcel: Parcel): Results {
            return Results(parcel)
        }

        override fun newArray(size: Int): Array<Results?> {
            return arrayOfNulls(size)
        }
    }

}

 class Info (

    @SerializedName("seed") var seed : String,
    @SerializedName("results") var results : Int,
    @SerializedName("page") var page : Int,
    @SerializedName("version") var version : String

) : KParcelable{
     constructor(parcel: Parcel) : this(
         parcel.readString()!!,
         parcel.readInt(),
         parcel.readInt(),
         parcel.readString()!!
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {

         parcel.writeString(seed)
         parcel.writeInt(results)
         parcel.writeInt(page)
         parcel.writeString(version)
     }

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Info> {
         override fun createFromParcel(parcel: Parcel): Info {
             return Info(parcel)
         }

         override fun newArray(size: Int): Array<Info?> {
             return arrayOfNulls(size)
         }
     }

 }