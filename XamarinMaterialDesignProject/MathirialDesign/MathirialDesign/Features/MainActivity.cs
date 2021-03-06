﻿using Android.App;
using Android.Widget;
using Android.OS;
using Android.Content;

namespace MathirialDesign
{
    [Activity(Label = "MathirialDesign", MainLauncher = true, Icon = "@mipmap/icon")]
    public class MainActivity : Activity
    {
        int count = 1;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.ActivityMain);

            // Get our button from the layout resource,
            // and attach an event to it
            Button button = FindViewById<Button>(Resource.Id.myButton);

            button.Click += delegate
            {
                button.Text = $"{count++} clicks!";
                NavigateToPage<InlineTextModificationView>();
            };
        }

        private void NavigateToPage<TView>()
            where TView : Activity
        {
            var intent = new Intent(this, typeof(TView));
            StartActivity(intent);
        }
    }
}

