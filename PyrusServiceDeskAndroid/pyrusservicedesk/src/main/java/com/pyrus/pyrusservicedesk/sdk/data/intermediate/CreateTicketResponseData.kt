package com.pyrus.pyrusservicedesk.sdk.data.intermediate

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.pyrus.pyrusservicedesk.sdk.data.Attachment

/**
 * Response data of create ticket request
 */
@Keep
internal data class CreateTicketResponseData(
    @SerializedName("ticket_id")
    val ticketId: Int,
    @SerializedName("attachments")
    val attachmentIds: List<Int>?,
    val sentAttachments: List<Attachment>?)
