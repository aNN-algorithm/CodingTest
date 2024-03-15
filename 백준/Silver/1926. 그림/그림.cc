#include <iostream>
#include <queue>
#define x first
#define y second

using namespace std;

int map[502][502] = { 0, };
int visit[502][502] = { 0, };
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int main()
{
	int n, m;
	int max = 0;
	int cnt = 0;
	int area = 0;

	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> map[i][j];
		}
	}

	queue<pair<int, int>> Q;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (map[i][j] == 1 && visit[i][j] == 0)
			{
				Q.push({ i, j });
				visit[i][j] = 1;
				cnt++;
				area = 1;

				while (!Q.empty())
				{
					pair<int, int> cur = Q.front();
					Q.pop();

					for (int k = 0; k < 4; k++)
					{
						int nx = cur.x + dx[k];
						int ny = cur.y + dy[k];

						if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						{
							continue;
						}
						if (map[nx][ny] != 1 || visit[nx][ny] == 1)
						{
							continue;
						}

						Q.push({ nx, ny });
						visit[nx][ny] = 1;
						area++;
					}
				}
				if (area > max)
				{
					max = area;
				}
			}
		}
	}

	cout << cnt << "\n" << max << "\n";
}