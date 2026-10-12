import {inject, Service} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AccountsResponseModel} from '../../models/accounts-model';

@Service()
export class AccountsService {

  private http = inject(HttpClient);
  private path = "http://localhost:8058/BANK-ACCOUNT-SERVICE/api/bank-account-service"

  getAllAccounts(): Observable<AccountsResponseModel[]> {
    return this.http.get<AccountsResponseModel[]>(this.path + "/accounts");
  }

}
