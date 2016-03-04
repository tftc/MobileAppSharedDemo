package cn.com.jinrifamily.greendaodemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import cn.com.jinrizhushi.Customer;
import cn.com.jinrizhushi.Order;

/**
 * 描述: 一对多
 * 作者: 刘倩
 * 日期: 16/1/19 15:03
 */
public class OneToManyActivity extends Activity implements OnClickListener {
    private EditText etCustomerName;
    private Button btnSave;
    private TextView tvCustomerName;
    private EditText etOrderCode;
    private Button btnOrderSave;
    private TextView tvOrdeCode;
    private TextView tvCustomerOrders;
    long count = 0;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_to_many);
        etCustomerName = (EditText) findViewById(R.id.et_customer_name);
        btnSave = (Button) findViewById(R.id.btn_customer_save);
        tvCustomerName = (TextView) findViewById(R.id.tv_show_customer_name);
        etOrderCode = (EditText) findViewById(R.id.et_order_code);
        btnOrderSave = (Button) findViewById(R.id.btn_order_save);
        tvOrdeCode = (TextView) findViewById(R.id.tv_show_order_code);
        tvCustomerOrders = (TextView)findViewById(R.id.tv_show_customer_orders);
        btnSave.setOnClickListener(this);
        btnOrderSave.setOnClickListener(this);
        dbHelper = DBHelper.getInstance(getApplicationContext());
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.equals(btnSave)) {
            if (dbHelper.getCustomer() == null||dbHelper.getCustomer().size()==0) {
                Customer customer = new Customer();
                customer.setId(1L);
                customer.setName(etCustomerName.getText().toString());
                dbHelper.addToCustomerTbale(customer);
                List<Customer> customers = dbHelper.getCustomer();
                if (customers != null && customers.size() > 0) {
                    tvCustomerName.setText(customers.get(0).getName());
                }
                List<Order> listOrders = dbHelper.getCustomer().get(0).getOrders();
                StringBuffer buffer =new StringBuffer();
                if(listOrders!=null&&listOrders.size()>0){
                    for (int i = 0;i<listOrders.size();i++)
                    {
                        Order order = listOrders.get(i);
                        buffer.append(order.getOrderCode() + "__");
                    }
                    tvCustomerOrders.setText(buffer.toString());
                }
            } else {
                tvCustomerOrders.clearComposingText();
                Toast.makeText(OneToManyActivity.this, "sorry,只能设置一次!", Toast.LENGTH_SHORT).show();
                List<Customer> customers = dbHelper.getCustomer();
                tvCustomerName.setText(customers.get(0).getName());
//                List<Order> listOrders = dbHelper.getCustomer().get(0).getOrders();
                //该处有小bug
                List<Order> orderList = dbHelper.getOrder();
                List<Order> listOrders = orderList.get(0).getCustomer().getOrders();

                if(listOrders!=null&&listOrders.size()>0){
                    StringBuffer buffer =new StringBuffer();
                    for (int i = 0;i<listOrders.size();i++)
                    {
                        Order order = listOrders.get(i);
                        buffer.append(order.getOrderCode()+"    ");
                    }
                    tvCustomerOrders.setText(buffer.toString());

                }
            }
        }else if(v.equals(btnOrderSave)){
            count++;
            Order order = new Order();
            order.setCustomerId(dbHelper.getCustomer().get(0).getId());
            order.setDate(new Date(System.currentTimeMillis()));
            order.setOrderCode(etOrderCode.getText().toString());
            dbHelper.addToOrderTable(order);
            List<Order> listOrder = dbHelper.getOrder();
            StringBuffer buffer = new StringBuffer();
            if(listOrder!=null&&listOrder.size()>0){
                for (int i =0;i<listOrder.size();i++)
                {
                    Order currentOrder = listOrder.get(i);
                    buffer.append(currentOrder.getOrderCode()+"     ");
                    tvOrdeCode.setText(buffer.toString());
                }
            }

        }

    }


}
