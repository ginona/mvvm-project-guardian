package com.example.mvvm_project_guardian.data.model

import android.os.Parcel
import android.os.Parcelable

data class Result (
    val id: String?,
    val type: String?,
    val webTitle: String?,
    val apiUrl: String?,
    val fields: Field?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readParcelable(Field::class.java.classLoader)
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(type)
        parcel.writeString(webTitle)
        parcel.writeString(apiUrl)
        parcel.writeParcelable(fields, Parcelable.PARCELABLE_WRITE_RETURN_VALUE)
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }

}