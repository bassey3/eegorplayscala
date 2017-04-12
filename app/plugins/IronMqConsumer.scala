package plugins

/**
  * Created by ex1 on 05/04/2017.
  */
import java.util

import scala.concurrent.future
import io.iron.ironmq.{Client, Messages, Queue}
import play.api.{Application, Play}


  case class IronMqConsumer() {

    private val MAX_BATCH_SIZE = 10
    private val queuename = "receiveq"
    private val webhookURL= "https://mq-aws-eu-west-1-1.iron.io/3/projects/58e2be5052c4150006d9bf3b/queues/receiveq/webhook?oauth=mOrk3s9rOX01jzd0uLGb"
    private val projectID = "58e2be5052c4150006d9bf3b"
    private val token = "mOrk3s9rOX01jzd0uLGb"
    private var client : Client = null
    private var receiveQ : Queue = null
    client = new Client(projectID,token)
    receiveQ = new Queue(client,queuename)

    def sendMessage(JSONmessage : String){
      println("sent message")
      receiveQ.push(JSONmessage)
    }

    def getAMessages(): Messages ={
       var messagelist = new Messages()
      messagelist = receiveQ.get(MAX_BATCH_SIZE)
      println("getting message")
        return messagelist
    }



}