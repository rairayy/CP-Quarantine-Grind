#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll ab(ll a){
  if (a<0) return -a;
  else return a;
}

int main(){
  ll x,y,x1,x2,y1,y2;
  cin >> x >> y >> x1 >> y1 >> x2 >> y2;
  if (x>=min(x1,x2) && x<=max(x1,x2)){
    cout<<fixed<<setprecision(3)<<min(ab(y1-y),ab(y2-y))+0.0;
  }
    else if (y>=min(y1,y2) && y<=max(y1,y2)){
    cout<<fixed<<setprecision(3)<<min(ab(x1-x),ab(x2-x))+0.0;
  }
  else{
    c1out<<fixed<<setprecision(3)<<min(pow(pow(x-x1,2)+pow(y-y1,2),0.5),pow(pow(x-x2,2)+pow(y-y2,2),0.5));
  }
}