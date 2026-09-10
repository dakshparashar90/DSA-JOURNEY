class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> list = new ArrayList<>();

        int i = num.length - 1;
        int carry = 0;

        while (i >= 0 || k != 0 || carry != 0) {

            int digit1 = (i >= 0) ? num[i] : 0;
            int digit2 = k % 10;

            int sum = digit1 + digit2 + carry;

            list.add(sum % 10);

            carry = sum / 10;

            k = k / 10;
            i--;
        }

        Collections.reverse(list);

        return list;
    }
}