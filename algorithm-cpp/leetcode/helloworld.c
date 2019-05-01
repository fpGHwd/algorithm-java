#include <stdio.h>
#include <string.h>
#include <math.h>
#include <algorithm>

// https://blog.csdn.net/u010732356/article/details/65970931

// n cores, processing = 1k/s, tasks[n], require length
// tasks[n] = A[a] + B[b] while a + b = n
// A[a] < B[b] and max(A[a])
// time[i][s] = max(time[i-1][s], time[i-1][s-v[i]] + v[i]) while s = taskSize

const int A = 10000;
int dp[10000][10000];

int main(int argc, char ** argv){

	freopen("input", "r", stdin);



	int n, task[A] ,sum = 0,temp;
	scanf("%d", &n);
	for(int i = 0; i < n; i++){
		scanf("%d", &temp);
		task[i] = temp/1024;
		sum += temp/1024;
	}

	memset(dp, 0, sizeof(dp));

	for(int i = 0; i<= n; i++){
		for(int j = 0; j ; ++j){

		}
		for(int j = sum/2; j > task[i]; --j){
			dp[j] = max(dp[j], dp[j-task[i]] + task[i]);
		}
	}

	printf("%d", sum-dp[j]);

	fclose(stdin);
	return 0;
}