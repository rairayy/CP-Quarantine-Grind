#include <bits/stdc++.h>
using namespace std;
char s[100001];
char check[100001];

int main(){
	ios_base::sync_with_stdio(false);
  	cin.tie(NULL); cout.tie(NULL);

  	int T,n,m,index;
  	char temp;
  	cin >> T;
  	for (int i=0; i<T; i++){
  		int ans=0;
  		cin >> n >> m;
  		for (int j=0; j<n; j++){
  			cin>>s[j];
  		}
  		int errors=0;
  		for (int j=0; j<n/2; j++){
  			if (s[j] != s[n-j-1]) errors++;
  		}
  		for (int j=0; j<m; j++) {
  			cin >> index >> temp;
			char a = s[index-1]; // the one that will change
			char b = s[n-index];
  			// cout<<s[index-1]<<" "<<s[n-index]<<endl;
			if( index-1 != n-index and b==temp and a!=temp) { // update will make a the same as b
				errors--;
			} else if ( index-1 != n-index and a == b and a != temp ) { // same at the start but update will change this
				errors++;
			}
			if( errors == 0 ) ans++;
			s[index-1] = temp;
  		}
  		cout<<ans<<endl;
  	}
}