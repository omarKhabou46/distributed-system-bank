import {inject, NgZone, Service} from '@angular/core';
import {HttpClient, HttpDownloadProgressEvent, HttpEvent, HttpEventType} from '@angular/common/http';
import {map, Observable} from 'rxjs';

export interface ChatStreamEvent {
  type: 'sent' | 'response' | 'complete' | 'other';
  content?: string;
}


@Service()
export class BotService {
  private http = inject(HttpClient);
  private path = "http://localhost:8058/CHATBOT-SERVICE/api/chat-service"
  private zone = inject(NgZone);


  chat(message: string, conversationId: string): Observable<string> {
      return this.http.get(this.path + '/chat', {
        params: {
          message: message,
          conversationId: conversationId
        },
        responseType: 'text'
      });
    }


  chatStream(message: string, conversationId: string): Observable<string> {
    return new Observable<string>(observer => {
      const url = `${this.path}/chatStream?message=${encodeURIComponent(message)}&conversationId=${encodeURIComponent(conversationId)}`;
      const es = new EventSource(url);

      es.onmessage = (event) => {
        this.zone.run(() => observer.next(event.data));
      };

      // Le serveur ferme la connexion à la fin du flux, ce qui déclenche onerror.
      // Il faut fermer, sinon EventSource se reconnecte automatiquement en boucle.
      es.onerror = () => {
        es.close();
        this.zone.run(() => observer.complete());
      };

      return () => es.close();
    });
  }
}
