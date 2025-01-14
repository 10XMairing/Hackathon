package com.github.tenx.agtechfarmer.di.modules.function;

import com.github.tenx.agtechfarmer.ui.Function.appointments.FarmerAppointmentsFragment;
import com.github.tenx.agtechfarmer.ui.Function.bookEquipments.BookEquipmentsFragment;
import com.github.tenx.agtechfarmer.ui.Function.buyItemFragment.BuyItemFragment;
import com.github.tenx.agtechfarmer.ui.Function.cart.CartFragment;
import com.github.tenx.agtechfarmer.ui.Function.createEquipments.CreateEquipmentFragment;
import com.github.tenx.agtechfarmer.ui.Function.meetingTheExpert.ExpertMeetingFragment;
import com.github.tenx.agtechfarmer.ui.Function.myEquipments.MyEquipments;
import com.github.tenx.agtechfarmer.ui.Function.notification.FarmerNotificationFragment;
import com.github.tenx.agtechfarmer.ui.Function.payments.FarmerPaymentsFragment;
import com.github.tenx.agtechfarmer.ui.Function.profile.MyProfileFragment;
import com.github.tenx.agtechfarmer.ui.Function.shop.ShopFragment;
import com.github.tenx.agtechfarmer.ui.Function.articles.ArticlesFragment;
import com.github.tenx.agtechfarmer.ui.Function.contactExperts.ContactExpertsFragment;
import com.github.tenx.agtechfarmer.ui.Function.prediction.PredictionFragment;
import com.github.tenx.agtechfarmer.ui.Function.questions.QuestionFragment;

import com.github.tenx.agtechfarmer.ui.Function.singleExpert.SingleExpertFragment;
import com.github.tenx.agtechfarmer.ui.Function.singleItemShop.SingleItemShopFragment;
import com.github.tenx.agtechfarmer.ui.Function.singleNotification.FarmerSingleNotificationFragment;
import com.github.tenx.agtechfarmer.ui.Function.singlearticle.SingleArticleFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FunctionFragmentBuilder {

    @ContributesAndroidInjector(modules = {})
    abstract ShopFragment bindAdvertisementsFragment();

    @ContributesAndroidInjector(modules = {})
    abstract ArticlesFragment bindArticlesFragment();

    @ContributesAndroidInjector(modules = {})
    abstract ContactExpertsFragment bindContactExpertsFragment();

    @ContributesAndroidInjector(modules = {})
    abstract QuestionFragment bindQuestionsFragment();

    @ContributesAndroidInjector(modules = {})
    abstract PredictionFragment bindPredictionFragment();

    @ContributesAndroidInjector
    abstract SingleArticleFragment bindSingleArticleFragment();

    @ContributesAndroidInjector
    abstract SingleItemShopFragment bindSingleItemShopFragment();

    @ContributesAndroidInjector
    abstract SingleExpertFragment bindSingleExpertFragment();

    @ContributesAndroidInjector
    abstract ExpertMeetingFragment bindExpertMeetingFragment();

    @ContributesAndroidInjector
    abstract CartFragment bindCartFragment();

    @ContributesAndroidInjector
    abstract FarmerSingleNotificationFragment bindFarmerSingleNotificationFrag();

    @ContributesAndroidInjector
    abstract FarmerNotificationFragment bindFarmerNotificationFrag();

    @ContributesAndroidInjector
    abstract FarmerAppointmentsFragment bindFarmerAppointmentsFrag();

    @ContributesAndroidInjector
    abstract BuyItemFragment bindBuyItemFragment();

    @ContributesAndroidInjector
    abstract BookEquipmentsFragment bindBookEquipmentsFragment();

    @ContributesAndroidInjector
    abstract FarmerPaymentsFragment bindFarmerPaymentsFragment();

    @ContributesAndroidInjector
    abstract CreateEquipmentFragment bindCreateEquipmentsFragment();

    @ContributesAndroidInjector
    abstract MyEquipments bindMyEquipments();

    @ContributesAndroidInjector
    abstract MyProfileFragment bindMyProfile();



}
