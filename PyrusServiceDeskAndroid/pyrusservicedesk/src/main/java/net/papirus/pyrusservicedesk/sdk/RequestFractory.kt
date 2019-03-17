package net.papirus.pyrusservicedesk.sdk

import net.papirus.pyrusservicedesk.sdk.data.Comment
import net.papirus.pyrusservicedesk.sdk.data.Ticket
import net.papirus.pyrusservicedesk.sdk.data.TicketDescription
import net.papirus.pyrusservicedesk.sdk.data.TicketShortDescription
import net.papirus.pyrusservicedesk.sdk.request.*
import net.papirus.pyrusservicedesk.sdk.web.UploadFileHooks

internal class RequestFactory(private val repository: Repository) {

    fun getConversationRequest(): RequestBase<List<Comment>> = GetConversationRequest(repository)
    fun getTicketsRequest(): RequestBase<List<TicketShortDescription>> = GetTicketsRequest(repository)
    fun getTicketRequest(ticketId: Int): RequestBase<Ticket> = GetTicketRequest(repository, ticketId)
    fun createTicketRequest(description: TicketDescription,
                            uploadFileHooks: UploadFileHooks): RequestBase<Int> {
        return CreateTicketRequest(repository, description, uploadFileHooks)
    }
    fun addCommentRequest(ticketId: Int,
                          comment: Comment,
                          uploadFileHooks: UploadFileHooks): RequestBase<Int> {
        return AddCommentRequest(repository, ticketId, comment, uploadFileHooks)
    }
}