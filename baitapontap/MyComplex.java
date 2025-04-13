
public class MyComplex {
private double real = 0.0;
private double imag = 0.0;
public MyComplex() {
}
public MyComplex(double real, double imag) {
	this.real = real;
	this.imag = imag;
}
public double getReal() {
	return real;
}
public void setReal(double real) {
	this.real = real;
}
public double getImag() {
	return imag;
}
public void setImag(double imag) {
	this.imag = imag;
}
public void setValue(double real, double imag) {
	this.imag = imag;
	this.real = real;
}

public String toString() {
	return "MyComplex = (" + real + "+ " + imag + "i)";
}
public boolean isReal() {
	return imag == 0.0;
}
public boolean isImaginary() {
	return real == 0.0;
}
public boolean equals(double real, double imag) {
	return (this.real == real && this.imag == imag);
}
public boolean equals(MyComplex another) {
	return (this.real == another.real && this.imag == another.imag);
}
// độ lớn của số phức
public double magnitude() {
	return Math.sqrt(real*real + imag*imag);
}
//tính góc pha của số phức
public double argument() {
	return Math.atan2(imag,real);
}
public MyComplex add(MyComplex right) {
    this.real += right.real;
    this.imag += right.imag;
    return this;
}

// Trả về số phức mới là tổng của số phức hiện tại và số phức khác
public MyComplex addNew(MyComplex right) {
    return new MyComplex(this.real + right.real, this.imag + right.imag);
}

// Trừ số phức khác khỏi số phức hiện tại
public MyComplex subtract(MyComplex right) {
    this.real -= right.real;
    this.imag -= right.imag;
    return this;
}

// Trả về số phức mới là hiệu của số phức hiện tại và số phức khác
public MyComplex subtractNew(MyComplex right) {
    return new MyComplex(this.real - right.real, this.imag - right.imag);
}

// Nhân số phức hiện tại với số phức khác
public MyComplex multiply(MyComplex right) {
    double newReal = this.real * right.real - this.imag * right.imag;
    double newImag = this.real * right.imag + this.imag * right.real;
    this.real = newReal;
    this.imag = newImag;
    return this;
}

// Chia số phức hiện tại cho số phức khác
public MyComplex divide(MyComplex right) {
    double denominator = right.real * right.real + right.imag * right.imag;
    double newReal = (this.real * right.real + this.imag * right.imag) / denominator;
    double newImag = (this.imag * right.real - this.real * right.imag) / denominator;
    this.real = newReal;
    this.imag = newImag;
    return this;
}

// Trả về số phức liên hợp của số phức hiện tại
public MyComplex conjugate() {
    return new MyComplex(this.real, -this.imag);
}
}
