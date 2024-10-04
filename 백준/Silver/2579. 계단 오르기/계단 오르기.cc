#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int stair[302];
int D[302];

int main()
{
	int N;
	
	cin >> N;
	for (int i = 1; i <= N; i++)
	{
		cin >> stair[i];
	}
	D[1] = stair[1];
	D[2] = stair[2] + stair[1];
	D[3] = stair[3] + max(stair[2], stair[1]);

	for (int i = 4; i <= N; i++)
	{
		D[i] = stair[i] + max((D[i - 3] + stair[i - 1]), D[i - 2]);
	}

	cout << D[N];
}