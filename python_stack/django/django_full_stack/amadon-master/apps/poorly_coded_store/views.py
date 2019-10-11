from django.shortcuts import render, redirect
from .models import Order, Product
from django.db.models import Sum

def index(request):
    context = {
        "all_products": Product.objects.all()
    }
    return render(request, "store/index.html", context)

def buy(request):
    if request.method == "POST":
        quantity_from_form = int(request.POST["quantity"])
        id = request.POST["id"]
        order = Order.objects.get(id=id)
    item_charge = quantity_from_form * order.total_price
    Order.objects.create(quantity_ordered=quantity_from_form, total_price=item_charge)
    return redirect('/checkout')

def checkout(request):
    ordered_quantities = Order.objects.aggregate(Sum('quantity_ordered'))
    ordered_quantities = ordered_quantities['quantity_ordered__sum']
    total_charge = Order.objects.aggregate(Sum('total_price'))
    total_charge = total_charge['total_price__sum']
    item = Order.objects.last()
    context= {
        
        'charge': item,
        'quantity': ordered_quantities,
        'total': total_charge,
    }
    return render(request, "store/checkout.html", context)
