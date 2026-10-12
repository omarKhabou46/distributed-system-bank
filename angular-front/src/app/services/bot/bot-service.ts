import {inject, Service} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Service()
export class BotService {
  private http = inject(HttpClient);
  private path = "http://localhost:8058/CHATBOT-SERVICE/api/chat-service"

  chat(message: string, conversationId: string): Observable<String> {
    return this.http.get<String>(this.path+"/chat", {
      params: {
        message: message,
        conversationId: conversationId
      }
    })
  }

}
