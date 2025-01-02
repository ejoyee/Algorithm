#include <iostream>
using namespace std;

int N, T = 1;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;
	while (N) {
		int ans = 0;
		for (int i = 5; i <= N; i *= 5) ans += N / i;
		cout << "Case #" << T++ << ": " << ans << '\n';
		cin >> N;
	}
}