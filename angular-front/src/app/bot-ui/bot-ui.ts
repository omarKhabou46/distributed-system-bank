import {Component, inject, OnInit, signal} from '@angular/core';
import {BotService} from '../services/bot/bot-service';
import {FormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {MarkdownComponent} from 'ngx-markdown';

@Component({
  imports: [
    ReactiveFormsModule,
    MarkdownComponent
  ],
  selector: 'app-bot-ui',
  styleUrl: './bot-ui.css',
  templateUrl: './bot-ui.html',
  standalone: true
})
export class BotUi {

  private readonly botService = inject(BotService);
  private fb = inject(FormBuilder);
  response = signal<string>("");
  isLoading = signal(false);

  askForm = this.fb.group({
    question: ['', Validators.required]
  });

  ask() {
    if (this.askForm.invalid) {
      return;
    }

    const question = this.askForm.value.question;
    if (question) {
      this.isLoading.set(true)
      this.botService.chat(question, "omar").subscribe({
        next: (res) =>  {
          this.isLoading.set(false);
          this.response.set(res);
        }
      })
    }
  }


  askStream() {
    if (this.askForm.invalid) return;

    const question = this.askForm.value.question;
    if (!question) return;

    this.response.set('');
    this.isLoading.set(true);

    this.botService.chatStream(question, 'omar').subscribe({
      next: (chunk) => this.response.update(current => current + chunk),
      complete: () => this.isLoading.set(false),
      error: (err) => {
        console.error('Erreur streaming :', err);
        this.isLoading.set(false);
      }
    });
  }



}
