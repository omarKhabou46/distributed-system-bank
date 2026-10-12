import {Component, inject, OnInit, signal} from '@angular/core';
import {AccountsService} from '../services/account/accounts-service';
import {AccountsResponseModel} from '../models/accounts-model';
import {DatePipe, DecimalPipe} from '@angular/common';

@Component({
  imports: [
    DatePipe,
    DecimalPipe
  ],
  selector: 'app-accounts',
  styleUrl: './accounts.css',
  templateUrl: './accounts.html',
})
export class Accounts implements OnInit {

  private readonly accountService = inject(AccountsService);
  accounts = signal<AccountsResponseModel[]>([]);
  isLoading = signal<boolean>(false)


  ngOnInit(): void {
    this.loadAccounts();
  }


  private loadAccounts(): void {
    this.isLoading.set(true);
    this.accountService.getAllAccounts().subscribe({
      next: (result) => {
        this.isLoading.set(false);
        this.accounts.set(result);
      } ,error: (err) => {
        console.log(err);
      }
    })
  }



}
