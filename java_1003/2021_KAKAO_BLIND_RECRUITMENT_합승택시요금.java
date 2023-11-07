import java.util.Arrays;

class Solution {
    
    static final int INF = (int)1e9;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[][] dist = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);          
            dist[i][i] = 0;
        }
        
        for(int i = 0; i < fares.length; i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            
            dist[c][d] = dist[d][c] = f;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dist[i][j] = Integer.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int result = dist[s][a] + dist[s][b];
        for(int i = 1; i <= n; i++) {
            if(dist[s][i] < INF && dist[i][a] < INF && dist[i][b] < INF) {
                result = Integer.min(result, dist[s][i] + dist[i][a] + dist[i][b]);   
            }
        }
        
        return result;
    }
}
