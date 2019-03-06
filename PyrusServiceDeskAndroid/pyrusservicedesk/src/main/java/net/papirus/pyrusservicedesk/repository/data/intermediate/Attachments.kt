package net.papirus.pyrusservicedesk.repository.data.intermediate

import com.google.gson.annotations.SerializedName
import net.papirus.pyrusservicedesk.repository.data.Attachment

internal data class Attachments(
        @SerializedName("attachments")
        val attachments: List<Attachment> = emptyList())