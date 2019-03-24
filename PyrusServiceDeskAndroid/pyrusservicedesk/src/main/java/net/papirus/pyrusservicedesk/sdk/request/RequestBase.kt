package net.papirus.pyrusservicedesk.sdk.request

import net.papirus.pyrusservicedesk.sdk.Repository
import net.papirus.pyrusservicedesk.sdk.response.ResponseBase
import net.papirus.pyrusservicedesk.sdk.response.ResponseCallback
import net.papirus.pyrusservicedesk.sdk.response.ResponseError

internal abstract class RequestBase<ResponseData>(private val repository: Repository) {

    protected abstract suspend fun run(repository: Repository): ResponseBase<ResponseData>

    suspend fun execute(callback: ResponseCallback<ResponseData>){
        with(run(repository)) {
            when {
                error != null -> callback.onFailure(error)
                result == null -> callback.onFailure(ResponseError.InvalidDataError)
                else -> callback.onSuccess(result)
            }
        }
    }
}