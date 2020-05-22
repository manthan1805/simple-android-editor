package kr.co.jsh.feature.videoedit

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

interface TrimmerContract {
    interface View{
        fun onVideoPrepared() //OnVideoListener
        fun onError(message: String)
        fun cancelAction()
        fun onTrimStarted()
        fun videoPath(path : String)
        fun resetCropView()
        fun setThumbnailListView(thumbnailList :  ArrayList<Bitmap>)
        fun setPairList(list : ArrayList<Pair<Int,Int>>)
        fun getResult(uri:Uri)

        //uploadFile result
        fun uploadSuccess(msg: String)
        fun uploadFailed(msg: String)

        //suspend thread
        fun cancelJob()
    }
    interface Presenter{
        var view: View
        fun prepareVideoPath(extraIntent: Intent)
        fun resetCrop(context:Context, crop_time: ArrayList<Pair<Int, Int>>)
        fun crop(context: Context, cropCount: Int, videoLoader:VideoView, crop_time: ArrayList<Pair<Int, Int>>, recycler: RecyclerView)
        fun getThumbnailList(mSrc: Uri, context: Context)
        fun trimVideo(path: String, context:Context, mSrc: Uri, start_sec: Int, end_sec: Int)
        fun getResultUri(uri:Uri, context:Context, option: String)


        //파일 정보를 서버로 보내서 객체로 묶어준다.
       // fun resultUriToServerWithInfo(uri: Uri, currentTime: Float, maskImg: Bitmap)

        //uploadVideoFile
        fun uploadFile(uri: Uri)

        //uploadMaskFile
        fun uploadMaskFile(bitmap: Bitmap, frameTimeSec: Float, context: Context)


        //upload specific Frame
     //   fun uploadFrameFile(bitmap: Bitmap, context: Context)
    }
}