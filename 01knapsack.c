#include <stdio.h>

// Function to find the maximum of two integers
int max(int a, int b) 
{
    return (a > b) ? a : b;
}

// Function to solve 0/1 Knapsack problem using dynamic programming
int knapsack(int m, int wt[], int val[], int n) 
{
    int i, j;
    int K[n + 1][m + 1]; // K[i][w] will store the maximum value that can be attained with a knapsack capacity of 'w' using the first 'i' items
    int sel[n + 1][m + 1]; // sel[i][w] will be true if item i is included in the knapsack with capacity 'w'

    // Build K[][] in bottom-up manner
    for (i = 0; i <= n; i++) 
    {
        for (j = 0; j <= m; j++) 
        {
            if (i == 0 || j == 0) 
            {
                K[i][j] = 0;
                sel[i][j] = 0;
            }
            else if (wt[i - 1] <= j) 
            {
                K[i][j] = max(val[i - 1] + K[i - 1][j - wt[i - 1]], K[i - 1][j]);
                if (val[i - 1] + K[i - 1][j - wt[i - 1]] > K[i - 1][j])
                    sel[i][j] = 1;
                else
                    sel[i][j] = 0;
            }
            else 
            {
                K[i][j] = K[i - 1][j];
                sel[i][j] = 0;
            }
        }
    }

    // Find the items that are included in the knapsack with maximum value
    int result = K[n][m];
    int capacity = m;
    printf("Items included in the knapsack:\n");
    for (i = n; i > 0 && result > 0; i--) 
    {
        if (sel[i][capacity]) 
        {
            printf("Item %d (weight = %d, value = %d)\n", i, wt[i - 1], val[i - 1]);
            result -= val[i - 1];
            capacity -= wt[i - 1];
        }
    }

    return K[n][m];
}

int main() 
{
    int val[] = {210, 100, 120};
    int wt[] = {50, 20, 30};
    int m = 50;
    int n = 3;

    printf("Maximum value that can be put in knapsack is: %d\n", knapsack(m, wt, val, n));
    return 0;
}
