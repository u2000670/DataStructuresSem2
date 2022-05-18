package com.company.Week3ADTsandBags.Tuto3.QN1;

public interface Container <T,U>{

    public void addItem(T t, U u );
    public void removeItem(T t);

}
/*(no order)
*Container
*-addItem()
*-removeItem() == get() ?
* -get() (for dispenser gets last item)
*
*Dispenser (Last In First Out -stack)
*
*/
