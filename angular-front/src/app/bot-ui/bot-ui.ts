import {Component, inject, OnInit, signal} from '@angular/core';
import {BotService} from '../services/bot/bot-service';
import {FormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';

@Component({
  imports: [
    ReactiveFormsModule
  ],
  selector: 'app-bot-ui',
  styleUrl: './bot-ui.css',
  templateUrl: './bot-ui.html',
  standalone: true
})
export class BotUi {

  private readonly botService = inject(BotService);
  private fb = inject(FormBuilder);
  response = signal<String>("");

  askForm = this.fb.group({
    question: ['', Validators.required]
  });

  ask() {
    if (this.askForm.invalid) {
      return;
    }

    const question = this.askForm.value.question;
    if (question) {
      this.botService.chat(question, "omar").subscribe({
        next: (res) =>  {
          this.response.set(res);
          this.askForm.reset();
        }
      })
    }


  }



}
