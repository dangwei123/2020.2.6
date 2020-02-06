class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        int cen=0;
        int len=0;
        for(int i=0;i<s.length();i++){
            int a=func(i,i,s);
            int b=func(i,i+1,s);
            int c=a>b?a:b;
            if(c>len){
                cen=i;
                len=c;
            }
        }
        return s.substring(cen-(len-1)/2,cen+len/2+1);
    }
    private int func(int left,int right,String s){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        StringBuffer sb=new StringBuffer("^#");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)).append("#");
        }
        sb.append("&");
        int[] p=new int[sb.length()];
        int C=0;
        int R=0; 
        for(int i=1;i<p.length-1;i++){
            int i_prim=2*C-i;
            if(R>i){
                p[i]=Math.min(p[i_prim],R-i);
            }else{
                p[i]=0;
            }

            while(sb.charAt(i+p[i]+1)==sb.charAt(i-p[i]-1)){
                p[i]++;
            }
            if(i+p[i]>R){
                C=i;
                R=i+p[i];
            }
        }
        int maxc=0;
        int maxlen=0;
        for(int i=1;i<p.length-1;i++){
            if(p[i]>maxlen){
                maxc=i;
                maxlen=p[i];
            }
        }
        int start=(maxc-maxlen)/2;
        return s.substring(start,start+maxlen);
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int[] max=new int[nums.length];
        int[] min=new int[nums.length];
        int res=nums[0];
        max[0]=nums[0];
        min[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            max[i]=Math.max(nums[i],Math.max(max[i-1]*nums[i],min[i-1]*nums[i]));
            min[i]=Math.min(nums[i],Math.min(max[i-1]*nums[i],min[i-1]*nums[i]));
            res=Math.max(res,max[i]);
        }
        return res;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++){
            int left=0;
            int right=j;
            while(left<right){
                int mid=(left+right)>>>1;
                if(dp[mid]<nums[i]){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            dp[left]=nums[i];
            if(left==j){
                j++;
            }
        }
        return j;
    }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        int[][] dp=new int[len][len];
        for(int i=len-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<len;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}

class Solution {
    public int findLength(int[] A, int[] B) {
        int a=A.length;
        int b=B.length;
        int[][] dp=new int[a+1][b+1];
        int res=0;
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(A[i]==B[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                    res=Math.max(res,dp[i+1][j+1]);
                }else{
                    dp[i+1][j+1]=0;
                }
            }
        }
        return res;
    }
}

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int len=A.length;
        int[][] dp=new int[len][len];
        int res=0;
        for(int i=2;i<len;i++){
            int left=0;
            int right=i-1;
            while(left<right){
                int sum=A[left]+A[right];
                if(sum==A[i]){
                    dp[right][i]=dp[left][right]+1;
                    res=Math.max(res,dp[right][i]);
                    left++;
                    right--;
                }else if(sum<A[i]){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res==0?0:res+2;
    }
}


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int a=text1.length();
        int b=text2.length();
        int[][] dp=new int[a+1][b+1];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[a][b];
    }
}

