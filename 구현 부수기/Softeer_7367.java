import java.util.*;

public class Main {

    public static void main(String[] args) {
        final int PRECISION = 12;
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[100005];
        int[] dp = new int[100005];
        int[] rdp = new int[100005];
        int[] premx = new int[100005];
        int[] sufmx = new int[100005];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
            dp[i] = rdp[i] = arr[i];
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + arr[i]);
        }
        System.out.println(Arrays.toString(dp));
        
        for (int i = n - 1; i >= 1; i--) {
            rdp[i] = Math.max(rdp[i], rdp[i + 1] + arr[i]);
        }

        premx[1] = dp[1];
        sufmx[n] = rdp[n];
        for (int i = 2; i <= n; i++) {
            premx[i] = Math.max(premx[i - 1], dp[i]);
        }
        for (int i = n - 1; i >= 1; i--) {
            sufmx[i] = Math.max(sufmx[i + 1], rdp[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 2; i <= n - 1; i++) {
            ans = Math.max(ans, premx[i - 1] + sufmx[i + 1]);
        }

        System.out.println(ans);
        scanner.close();
    }
}
