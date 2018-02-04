/**
  * @author David Kapanga
 */
public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    
    public Rational add(Rational a)
    {
        Rational b=new Rational(1,1);
        b.setNumerator((this.getNumerator()*a.getDenominator())+(this.getDenominator()*a.getNumerator()));
        b.setDenominator(this.getDenominator()*a.getDenominator());
        return b;
    }
      public Rational sub(Rational a)
    {
        Rational b=new Rational(1,1);
        b.setNumerator((this.getNumerator()*a.getDenominator())-(this.getDenominator()*a.getNumerator()));
        b.setDenominator(this.getDenominator()*a.getDenominator());
        return b;
    }
    public Rational multiply(Rational a)
    {
        Rational b=new Rational(1,1);
        b.setDenominator(a.getDenominator()*this.getDenominator());
        b.setNumerator(a.getNumerator()*this.getNumerator());
        return b;
    }
    public Rational divide(Rational a)
    {
        Rational b=new Rational(1,1);
        b.setNumerator(this.getNumerator()*a.getDenominator());
        b.setDenominator(this.getDenominator()*a.getNumerator());
        return b;
    }
      public String getPrint()
    {
        String prt=this.getNumerator()+"/"+this.getDenominator();
        return prt;
    }
    public boolean greaterThan(Rational a)
    {
        boolean b=false;
        if((this.getNumerator()/(double)this.getDenominator()) >(a.getNumerator()/(double)a.getDenominator()))
        {
            b=true;
        }        
        return b;
    }
    public boolean lessThan(Rational a)
    {
        boolean b=false;
        if((this.getNumerator()/(double)this.getDenominator()) <(a.getNumerator()/(double)a.getDenominator()))
        {
            b=true;
        }        
        return b;
    }
    public boolean isEquals(Rational a)
    {
        boolean b=false;
        if((this.getNumerator()/(double)this.getDenominator()) == (a.getNumerator()/(double)a.getDenominator()))
        {
            b=true;
        }        
        return b;
    }
    
}
