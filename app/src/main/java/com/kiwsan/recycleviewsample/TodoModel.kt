package com.kiwsan.recycleviewsample

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TodoModel(
    @SerializedName("name") val name: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TodoModel> {
        override fun createFromParcel(parcel: Parcel): TodoModel {
            return TodoModel(parcel)
        }

        override fun newArray(size: Int): Array<TodoModel?> {
            return arrayOfNulls(size)
        }
    }
}