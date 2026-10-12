

export interface AccountsResponseModel {
  id: number;
  balance: number;
  createdAt: string;
  type: AccountType;
  customerId: number;
  customerName: string
}

enum AccountType {
  CURRENT_ACCOUNT= "CURRENT_ACCOUNT",
  SAVING_ACCOUNT= "SAVING_ACCOUNT"
}
