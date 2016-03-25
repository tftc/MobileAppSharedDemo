require 'spec_helper'

describe "StaticPages" do
  # describe "Home page" do
  #   it "should contain 'Sample App'" do
  #     # Run the generator again with the --webrat flag if you want to use webrat methods/matchers
  #   #   get static_pages_index_path
  #   #   response.status.should be(200)
  #       visit '/static_pages/home'
  #       expect(page).to have_content('Sample App')
  #   end
  # end

  describe "Test about page" do
      it "should contain  'About me'" do
          visit '/static_pages/about'
          expect(page).to have_content 'About me'
      end
  end


end
