import {inject, Service} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Service()
export class BotService {
  private http = inject(HttpClient);
  private path = "http://localhost:8058/CHATBOT-SERVICE/api/chat-service"

    chat(message: string, conversationId: string): Observable<string> {
      return this.http.get(this.path + '/chat', {
        params: {
          message: message,
          conversationId: conversationId
        },
        responseType: 'text'
      });
    }

}
