/*
 * The MIT License
 *
 * Copyright 2015 peter.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fpinjava;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Sum the 10% discounted prices of prices > 20.
 * @author Peter Cappello
 */
public class FPinJava 
{
    public static void main( String[] args )
    {
        final List<BigDecimal> priceList = Arrays.asList(
                new BigDecimal( "10" ), new BigDecimal( "30" ),
                new BigDecimal( "17" ), new BigDecimal( "20" ),
                new BigDecimal( "15" ), new BigDecimal( "18" ),
                new BigDecimal( "45" ), new BigDecimal( "12" )
        );
        
        // functional style
        final BigDecimal functionalSumOfDiscountedPrices =
                priceList.stream()
                .filter( price -> price.compareTo( BigDecimal.valueOf( 20 ) ) > 0 )
                .map( price -> price.multiply( BigDecimal.valueOf( 0.9 ) )  )
                .reduce( BigDecimal.ZERO, BigDecimal::add );
        
        // imperative style
        BigDecimal imperativeSumOfDiscountedPrices = BigDecimal.ZERO;       
        for ( BigDecimal price : priceList )
        {
            if ( price.compareTo( BigDecimal.valueOf( 20 ) ) > 0 )
            {
                imperativeSumOfDiscountedPrices = imperativeSumOfDiscountedPrices.add( price.multiply( BigDecimal.valueOf( 0.9 ) ) );
            }
        }
        
        System.out.println(
                "functionalSumOfDiscountedPrices: " + functionalSumOfDiscountedPrices +
                "\nimperativeSumOfDiscountedPrices: " + imperativeSumOfDiscountedPrices 
        );
    }
}
