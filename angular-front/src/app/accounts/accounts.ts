import {Component, inject, OnInit, signal} from '@angular/core';
import {AccountsService} from '../services/account/accounts-service';
import {AccountsResponseModel} from '../models/accounts-model';

@Component({
  imports: [],
  selector: 'app-accounts',
  styleUrl: './accounts.css',
  templateUrl: './accounts.html',
})
export class Accounts implements OnInit {

  private readonly accountService = inject(AccountsService);
  accounts = signal<AccountsResponseModel[]>([]);


  ngOnInit(): void {
    this.loadAccounts();
  }


  private loadAccounts(): void {
    this.accountService.getAllAccounts().subscribe({
      next: (result) => {
        this.accounts.set(result);
      } ,error: (err) => {
        console.log(err);
      }
    })
  }



}
