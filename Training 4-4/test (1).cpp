#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll factorial[200001];
ll rfactorial[200001];
const ll MOD=1000000007;


ll pow(ll a, ll b, ll MOD){
	if (b==0) return 1;
	else if (b%2==1){
		return (a*pow(a,b-1,MOD))%MOD;
	} else{
		ll temp=pow(a,b/2, MOD);
		return (temp*temp)%MOD;
	}
}

void init(){
	ll temp=1;
	factorial[0]=1;
	for (int i=1; i<200001; i++){
		temp=(temp*i)%MOD;
		factorial[i]=temp;
	}
	for (int i=0; i<200001; i++){
		rfactorial[i]=pow(factorial[i],MOD-2,MOD);
	}
	for (int i=0; i <200001; i++) {
		cout << rfactorial[i] << endl;
	}
}

ll C(ll n, ll k, ll MOD){
	return (((factorial[n]*rfactorial[k])%MOD)*rfactorial[n-k])%MOD;
}





int main(){
	ios_base::sync_with_stdio(false);
  	cin.tie(NULL); cout.tie(NULL);
  	init();
  	//cout<<C(6,3,MOD)<<endl;
  	int T,n,m;
  	cin >> T;
  	for (int i=0; i<T; i++){
  		cin >> n >> m;
  		int temp;
  		if ((m-abs(n))%2!=0) cout<<0<<endl;
  		else {
  			//temp=(m-abs(n))/2;
  			//cout<<abs(n)<<endl;
  			//cout<<C(m,(m+abs(n))/2,MOD)<<endl;
  			ll base=pow(2,m,MOD);
  			//cout<<base<<endl;
  			cout<<(C(m,(m+abs(n))/2,MOD)*pow(base,MOD-2,MOD))%MOD<<endl;
  		}
  	}
}