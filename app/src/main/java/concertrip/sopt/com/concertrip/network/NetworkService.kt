package concertrip.sopt.com.concertrip.network

import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface NetworkService {

    //POST 타입 (JsonObject로 받을때)
    @POST("")
    fun ex_posttype(
        @Header("") content_type : String,
        @Body() body:JsonObject
    ) //:Call<>

    //POST 타입 <파일로 받을때)
    @Multipart
    @POST("")
    fun ex_posttype2(
        @Header("") token : String,
        @Part("") title : RequestBody,
        @Part("") contents : RequestBody,
        @Part photo: MultipartBody.Part?
    ) //:Call<>


    //GET 타입
    @GET
    fun ex_gettype(
        @Header("") content_type: String,
        @Query("") offset : Int,
        @Query("") limit : Int
    ) //: Call<>

}