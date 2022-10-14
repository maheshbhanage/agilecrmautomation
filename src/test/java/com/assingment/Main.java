package com.assingment;

public class Main {

	public static void main(String[] args) {

		Mathmatics m1 = new Mathmatics() {
			int a = 10;
			int b = 20;
			int add = a + b;

			public int addition() {
				System.out.println(a + b);
				return add;
			}

			public void substraction() {
				System.out.println(a - b);
			}

			public void multiplication() {
				System.out.println(a * b);
			}

			public void dividation() {
				System.out.println(a / b);

			}
		};
		m1.addition();
		m1.substraction();
		m1.dividation();
		m1.multiplication();
	}
}
